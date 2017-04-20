<div class="container" id="i18_projects">
    <div class="row m-b-lg">
        <div class="col-lg-12 text-center">
            <div class="navy-line"></div>
            <h1><span data-i18n="projects.my_projects">My Projects</span></h1>
        </div>
    </div>
    <div class="row">
        <#list projects as project>
            <div class="col-sm-6 wow <#if project?index % 2 == 0> fadeInLeft <#else> fadeInRight </#if>">
              <div class="team-member">
                  <img src="${project.img}" alt="Project ${project.visibleName} image" class="img-responsive img-circle img-small" alt="">
                  <h4><a href="${project.linkTo}" target="blank"><span class="navy">${project.visibleName}</a></span></h4>
                  <p><span data-i18n="projects.${project.descT}"> Desc </span></p>
              </div>
          </div>
    </#list>
    </div>
</div>
<br>
