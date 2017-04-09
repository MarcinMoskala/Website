<div class="container" id="i18_career">
    <div class="row">
        <div class="col-lg-12 text-center">
            <div class="navy-line"></div>
            <h1><span data-i18n="career.my_career">My Career</span></h1>
        </div>
    </div>
    <div class="row features-block">
        <div class="col-lg-12">
            <div id="vertical-timeline" class="vertical-container light-timeline center-orientation">
            <#list careers as career>
                <div class="vertical-timeline-block">
                    <div class="vertical-timeline-icon navy-bg wow rotateIn">
                        <i class="fa ${ career.icon }"></i>
                    </div>1
                    <div class="vertical-timeline-content wow <#if section?index % 2 == 0> rotateInUpRight <#else> rotateInUpLeft </#if>">
                        <h2><span data-i18n="career.${ career.nameT }"> Name </span></h2>
                        <p><span data-i18n="career.${ career.detailT }"> Detail </span></p>
                        <span class="vertical-date"><span data-i18n="career.${ career.dateT }"> Date </span>
                        <br/> <small><span data-i18n="career.${ career.jobT }"> Detail </span></small> </span>
                    </div>
                </div>
            </#list>
            </div>
        </div>
    </div>
</div>
