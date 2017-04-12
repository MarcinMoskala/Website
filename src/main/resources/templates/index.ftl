<!DOCTYPE html>
<html>
<#include "header.ftl">
<body id="page-top" class="landing-page">
<div class="navbar-wrapper">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top" id="i18_title"><span data-i18n="website.title">${ title }</span></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right" id="i18_navbar">
                <#list sections as section>
                    <li>
                      <a class="page-scroll" href="#${ section.name }">
                        <span data-i18n="${ section.titleT }">${ section.title }</span>
                      </a>
                    </li>
                </#list>
                    <li>
                      <a class="page-scroll" href="/blog/">
                        <span data-i18n="nav.blog">Blog</span>
                      </a>
                    </li>

                 <#list languages as language>
                  <li>
                    <a id="set_lang_${ language.locale }" class="btn btn-sm set_${ language.locale }" data-locale="${ language.locale }">
                      <img src="/${language.flag}" height="16px" width="16px">
                    </a>
                  </li>
                </#list>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="inSlider" class="carousel carousel-fade" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#inSlider" data-slide-to="0" class="active"></li>
        <li data-target="#inSlider" data-slide-to="1"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <div class="container">
                <div class="carousel-caption">
                </div>
                <div class="carousel-image wow zoomIn">
                    <!-- <img src="static/img/landing/laptop.png" alt="laptop"/> -->
                </div>
            </div>
            <!-- Set background for slide in css -->
            <div class="header-back one"></div>
        </div>
        <div class="item">
            <div class="container">
                <div class="carousel-caption blank">
                </div>
            </div>
            <!-- Set background for slide in css -->
            <div class="header-back two"></div>
        </div>
    </div>
    <a class="left carousel-control" href="#inSlider" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#inSlider" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<#list sections as section>
  <section id="${ section.name }" class="features <#if !section?is_even_item> gray-section </#if> ${section.css}" style="margin-top: 0px;">
      <#include "sections/${section.tpl}">
  </section>
</#list>

<section class="features contact" style="margin-top: 0px;">
    <div class="container" id="i18_link">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center m-t-lg m-b-lg">
                <strong>Marcin Moskala Website</strong></p>
            </div>
        </div>
    </div>
</section>

<#include "/footer.ftl">

</body>
</html>