<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Faculty Info</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <style>
        <%@include file="../css/style1.css" %>
    </style>
    <style>
        <%@include file="../css/header.css" %>
    </style>
    <style>
        <%@include file="../css/fontss.css" %>
    </style>
    <style>
        <%@include file="../css/fonts.css" %>
    </style>
    <style>
        <%@include file="../css/panel-color.css" %>
    </style>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body class="home">
<header id="masthead" class="site-header left-aligned has-header-media" role="banner">
    <div class="site-logo-area">
        <div class="site-container">
            <div class="branding">
                <a href="http://localhost:8888" title="Faculty Info" class="title">Faculty Info</a>
                <div class="description">Every news you need to know about you faculty</div>
            </div>
            <div class="site-header-right ">
                <div class="top info-text-one">
                    <div class="info-text">
                    </div>
                </div>
                <div class="bottom social-links">
                    <ul class="social-links">
                        <li><a href="/login" title="Login"><i class="fas fa-sign-in-alt"></i></a></li>
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
                                href="http://localhost:8888/">Home</a></li>
                        <li id="menu-item-3"
                            class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children">
                            <span class="menu-dropdown-btn"><i class="otb-fa otb-fa-angle-right"></i></span><a
                                href="/category/">Categories</a>
                            <ul class="sub-menu">
                                <li id="menu-item-31" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/category/sport/">Sport</a></li>
                                <li id="menu-item-32"
                                    class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children">
                                    <span class="menu-dropdown-btn"><i class="otb-fa otb-fa-angle-right"></i></span><a
                                        href="/category/science/">Science</a>
                                    <ul class="sub-menu">
                                        <li id="menu-item-321"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/category/science/cs">Computer Science</a></li>
                                        <li id="menu-item-322"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/category/science/ee">Electrical Engineering</a></li>
                                        <li id="menu-item-323"
                                            class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                                href="/category/science/et">Energy Technology</a></li>
                                    </ul>
                                </li>
                                <li id="menu-item-33" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/category/entertainment/">Entertainment</a></li>
                                <li id="menu-item-34" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/category/faculty/">Faculty</a></li>
                                <li id="menu-item-35" class="menu-item menu-item-type-post_type menu-item-object-page">
                                    <a href="/category/uncategorized/">No category</a></li>
                            </ul>
                        </li>
                        <li id="menu-item-4" class="menu-item menu-item-type-post_type menu-item-object-page"><a
                                href="/sciboard/">Scientific Board</a></li>
                        <li id="menu-item-5"
                            class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item current_page_item">
                            <a href="/contact/">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="header-image-padder">
    <div class="header-image" style="height: auto;">
        <img src=" " alt=""
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
                    <header class="entry-header">
                        <h1 class="entry-title">Contact</h1>
                    </header>
                    <div class="entry-content">
                        <h4><strong>E-mail</strong></h4>
                        <h3><span style="font-size: 12pt;">email1@gmail.com</span><br>
                            <span style="font-size: 12pt;">email2@gmail.com</span><br></h3>
                        <h4><strong>Main office</strong></h4>
                        <h3><span style="font-size: 12pt;">Politechnika Krakowska im. Tadeusza Kosciuszki</span><br>
                            <span style="font-size: 12pt;">Warszawska 24, 31-155 Krakow</span><br>
                            <span style="font-size: 12pt;">Budynek Wydzialu Inzynierii Elektrycznej i Komputerowej</span><br>
                            <span style="font-size: 12pt;">pokój 999</span><br></h3>
                    </div>
                </div>
            </main>
        </div>
        <div id="secondary" class="widget-area" role="complementary">
            <aside id="search-2" class="widget widget_search">
                <form role="search" method="get" class="search-form" action="/search">
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
                    <li class="cat-item cat-item-2"><a href="/category/sport/">Sport</a>
                    </li>
                    <li class="cat-item cat-item-3"><a href="/category/science/">Science</a>
                    </li>
                    <li class="cat-item cat-item-12"><a href="/category/entertainment/">Entertainment</a>
                    </li>
                    <li class="cat-item cat-item-4"><a href="/category/faculty/">Faculty</a>
                    </li>
                    <li class="cat-item cat-item-1"><a href="/category/uncategorized/">No category</a>
                    </li>
                </ul>
            </aside>
            <aside class="widget widget_meta" id="meta-2"><h2 class="widget-title">Meta</h2>
                <ul>
                    <li><a href="/login">Log in</a></li>
                    <li><a href="/register">Register</a></li>
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