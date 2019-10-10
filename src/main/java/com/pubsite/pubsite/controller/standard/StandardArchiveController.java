package com.pubsite.pubsite.controller.standard;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.Archive;
import com.pubsite.pubsite.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class StandardArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @Autowired
    private StandardArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    public Optional<Archive> findOne(@PathVariable Integer id) {
        return archiveService.findOne(id);
    }

    public void addArchive(@RequestBody Archive archive) {
        this.archiveService.addArchive(archive);
    }

    public void deleteArchive(@PathVariable Integer id) {
        this.archiveService.deleteArchive(id);
    }

    public List<Archive> archiveList() {
        return Lists.reverse(archiveService.archiveList());
    }

    @RequestMapping("/standard/archive/download/{archiveId}")
    public String download(@PathVariable("archiveId")
                                   Integer archiveId, HttpServletResponse response) throws IOException, SQLException {


        Optional<Archive> archive = archiveService.findOne(archiveId);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "inline; filename=\"" + archive.get().getFilename() + "\"");
        File file = new File(archive.get().getContent());
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();
        byte[] outputByte = new byte[4096];
        while (fileInputStream.read(outputByte, 0, 4096) != -1)
            out.write(outputByte, 0, 4096);

        fileInputStream.close();
        out.flush();
        out.close();

        return null;
    }

    @RequestMapping("/standard/archive")
    public String Archive(Model model) {
        model.addAttribute("archiveList", archiveList());
        model.addAttribute("message", "Archive !!!");
        return "standard/standard-archive";
    }
}
