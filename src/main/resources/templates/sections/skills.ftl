<div class="container">
    <div class="row">
        <div class="col-lg-12 text-center" id="i18_skills">
            <div class="navy-line"></div>
            <h1><span data-i18n="skills.my_skills">My Skills</span></h1>
        </div>
    </div>
    <div class="row features-block">
        <#list skills as skill>
        <a href="${ skill.linkTo }">
            <div class="row">
                <div class="col-lg-1 col-lg-offset-2 wow <#if skill?index % 2 == 0> fadeInLeft <#else> fadeInRight </#if>">
                    <p>${ skill.visibleName }</p>
                </div>
                <div class="col-lg-7 wow <#if skill?index % 2 == 0> fadeInLeft <#else> fadeInRight </#if>">
                    <div class="progress progress-bar-default">
                        <div style="width: ${ skill.percentage }%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="${ skill.percentage }" role="progressbar" class="progress-bar">
                        </div>
                    </div>
                </div>
            </div>
        </a>
        <br>
        </#list>
    </div>
</div>
