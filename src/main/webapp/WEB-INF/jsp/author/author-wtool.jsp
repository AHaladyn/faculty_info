<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Faculty Info</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style>
        <%@include file="../../css/style.css" %>
    </style>
    <style>
        <%@include file="../../css/style1.css" %>
    </style>
    <style>
        <%@include file="../../css/header.css" %>
    </style>
    <style>
        <%@include file="../../css/fontss.css" %>
    </style>
    <style>
        <%@include file="../../css/fonts.css" %>
    </style>
    <style>
        <%@include file="../../css/panel-color.css" %>
    </style>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=opr9vbop120o9wylthj8rimujug4umtcr6czc0gndfpoejwm"></script>
    <script>tinymce.init({
        selector: 'title_area',
        branding: false,
        min_height: 500,
        max_width: false,
        plugins: 'codesample code lists',
        codesample_languages: [
            {text: 'HTML/XML', value: 'markup'},
            {text: 'JavaScript', value: 'javascript'},
            {text: 'CSS', value: 'css'},
            {text: 'PHP', value: 'php'},
            {text: 'Ruby', value: 'ruby'},
            {text: 'Python', value: 'python'},
            {text: 'Java', value: 'java'},
            {text: 'C', value: 'c'},
            {text: 'C#', value: 'csharp'},
            {text: 'C++', value: 'cpp'}
        ],
        toolbar: 'codesample code numlist bullist',
        content_css: [
            '//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
            '//www.tiny.cloud/css/codepen.min.css'
        ]
    });
    </script>
    <style>
        .mce-notification-inner {
            display: none !important;
        }
    </style>
</head>
<body class="home">
<header id="masthead" class="site-header left-aligned has-header-media" role="banner">
    <div class="site-logo-area">
        <div class="site-container">
            <div class="branding">
                <a href="http://localhost:8888/author/" title="Faculty Info" class="title">Faculty Info</a>
                <div class="description">Every news you need to know about you faculty</div>
            </div>
            <div class="site-header-right ">
                <div class="top info-text-one">
                    <div class="info-text">
                    </div>
                </div>
                <div class="bottom social-links">
                    <ul class="social-links">
                        <li><a href="<c:url value="/logout"/>" title="Logout"><i class="fas fa-sign-out-alt"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="clearboth"></div>
        </div>
    </div>
    <nav id="site-navigation"
         class="main-navigation border-bottom centered-submenu rollover-background-color uppercase left-aligned "
         role="navigation">
        <span class="header-menu-button"><i class="otb-fa otb-fa-bars"></i></span>
        <div id="main-menu" class="main-menu-container">
            <div class="main-menu-close"><i class="otb-fa otb-fa-angle-right"></i><i
                    class="otb-fa otb-fa-angle-left"></i></div>
            <div class="main-navigation-inner">
                <div class="menu-primary-container">
                    <ul id="menu-primary" class="menu">
                        <li id="menu-item-1" class="menu-item menu-item-type-custom menu-item-object-custom"><a
                                href="http://localhost:8888/author/">Home</a></li>
                        <li id="menu-item-2"
                            class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item current_page_item">
                            <a href="/author/wtool/">Publication tool</a></li>
                        <li id="menu-item-7"
                            class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children">
                            <span class="menu-dropdown-btn"><i class="otb-fa otb-fa-angle-right"></i></span><a
                                href="/author/myarticle/">My Articles</a>
                            <ul class="sub-menu">
                                <li id="menu-item-71" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/myarticle/finished">Approved articles</a></li>
                                <li id="menu-item-72" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/myarticle/saved">Saved articles</a></li>
                                <li id="menu-item-73" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/myarticle/rejected">Rejected article</a></li>
                            </ul>
                        </li>
                        <li id="menu-item-3" class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                href="/author/archive/">Archives</a></li>
                        <li id="menu-item-4"
                            class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children">
                            <span class="menu-dropdown-btn"><i class="otb-fa otb-fa-angle-right"></i></span><a
                                href="/author/category/">Categories</a>
                            <ul class="sub-menu">
                                <li id="menu-item-41" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/category/sport/">Sport</a></li>
                                <li id="menu-item-42"
                                    class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children">
                                    <span class="menu-dropdown-btn"><i class="otb-fa otb-fa-angle-right"></i></span><a
                                        href="/author/category/science/">Science</a>
                                    <ul class="sub-menu">
                                        <li id="menu-item-421"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/author/category/science/cs">Computer Science</a></li>
                                        <li id="menu-item-422"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/author/category/science/ee">Electrical Engineering</a></li>
                                        <li id="menu-item-423"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/author/category/science/et">Energy Technology</a></li>
                                    </ul>
                                </li>
                                <li id="menu-item-43" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/category/entertainment/">Entertainment</a></li>
                                <li id="menu-item-44" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/category/faculty/">Faculty</a></li>
                                <li id="menu-item-45" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/author/category/uncategorized/">No category</a></li>
                            </ul>
                        </li>
                        <li id="menu-item-5" class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                href="/author/sciboard/">Scientific Board</a></li>
                        <li id="menu-item-6" class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                href="/author/contact/">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="header-image-padder">
    <div class="header-image" style="height: auto;">
        <img src="" alt=""
             width="2810" height="1198">
        <div class="opacity"></div>
    </div>
</div>
<div class="content-container extra-padded">
    <div id="content" class="site-content site-container ">
        <div id="primary" class="content-area ">
            <main id="main" class="site-main" role="main">
                <div class="archive-container">
                    <div class="code-block code-block-1"
                         style="margin: 8px auto; text-align: center; display: block; clear: both;"></div>
                    <h3 style="color:green;font-weight: 900;"><c:out value="${resultMessage}"/></h3>
                    <h2>Tool for authors</h2>
                    <h4>Requirements about article</h4>
                    <c:forEach items="${requirementsList}" var="record">
                        <s:property value="${record.requirement}"/>
                    </c:forEach>
                    <div class="article-content">
                        <div class="article">
                            <form id="articleForm" name="articleForm" method="get">
                                <input type="text" placeholder="Input title here" class="form-control" name="name"
                                       autofocus="true"></br>
                                </br>
                                <title_area id="title" name="title" class="form-control" autofocus="true">Input content</title_area>
                                </br>
                                <div class="form-group" style="padding-bottom: 10px">
                                    <button name="autart" type="submit" class="primary submit-btn">Send article to proofread</button>
                                </div>
                                <div class="form-group" style="padding-bottom: 10px">
                                    <button name="saveautart" type="submit" class="primary submit-btn">Save article</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <nav class="navigation paging-navigation" role="navigation"></nav>
                </div>
            </main>
        </div>
        <div id="secondary" class="widget-area" role="complementary">
            <aside id="search-2" class="widget widget_search">
                <form role="search" method="get" class="search-form" action="/author/search">
                    <label>
                        <input type="search" class="search-field" placeholder="Search..." value="" name="s"
                               title="Search for:">
                    </label>
                    <div class="search-submit-container">
                        <a class="search-submit" type="submit" onclick="/search">
                            <button class="fas fa-search" type="submit"></button>
                        </a>
                    </div>
                </form>
            </aside>
            <aside id="text-8" class="widget widget_text"><h2 class="widget-title">Current Status:</h2>
                <div class="textwidget"><p>Next issue comes out <strong>12/08</strong>!</p>
                </div>
            </aside>
            <aside id="categories-2" class="widget widget_categories"><h2 class="widget-title">Categories</h2>
                <ul>
                    <li class="cat-item"><a href="/author/category/sport/">Sport</a>
                    </li>
                    <li class="cat-item"><a href="/author/category/science/">Science</a>
                    </li>
                    <li class="cat-item"><a href="/author/category/entertainment/">Entertainment</a>
                    </li>
                    <li class="cat-item"><a href="/author/category/faculty/">Faculty</a>
                    </li>
                    <li class="cat-item"><a href="/author/category/uncategorized/">No category</a>
                    </li>
                </ul>
            </aside>
            <aside class="widget widget_meta" id="meta-2"><h2 class="widget-title">Meta</h2>
                <ul>
                    <li><a href="<c:url value="/logout" />">Logout</a></li>
                    <li><a href="/author/profile">Profile</a></li>

                </ul>
            </aside>
        </div>
    </div>
</div>
<footer id="colophon" class="site-footer" role="contentinfo">
    <div class="site-footer-widgets">
        <div class="site-container">
            <div class="clearboth"></div>
        </div>
    </div>
    <div class="site-footer-bottom-bar">
        <div class="site-container">
            <div class="site-footer-bottom-bar-left">
                Made by AH
            </div>
            <div class="site-footer-bottom-bar-right">
            </div>
        </div>
        <div class="clearboth"></div>
    </div>
</footer>
</body>
</html>