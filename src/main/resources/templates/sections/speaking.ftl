<div class="container" id="i18_speaking">
    <div class="row">
        <div class="col-lg-12 text-center">
            <div class="navy-line"></div>
            <h1><span data-i18n="speaking.my_speaking">Writing and speaking</span></h1>
        </div>
    </div>
    <div class="row features-block">
        <div class="col-lg-12">
            <div id="vertical-timeline" class="vertical-container light-timeline center-orientation">
            <#list speaking as speak>
                <div class="vertical-timeline-block">
                    <div class="vertical-timeline-icon navy-bg wow rotateIn">
                        <i class="fa ${ speak.icon }}"></i>
                    </div>
                    <div class="vertical-timeline-content wow <#if speak?index % 2 == 0> rotateInUpRight <#else> rotateInUpLeft </#if> ">
                        <h2><a href="${ speak.link }"><span data-i18n="speaking.${ speak.nameT }"></span></a></h2>
                        <p><span data-i18n="speaking.${speak.detailT}"> </span></p>
                        <span class="vertical-date"><span data-i18n="speaking.{{ speak.dateT }}"></span>
                        <br/> <small><span data-i18n="speaking.{{ speak.jobT }}"></span></small> </span>
                    </div>
                </div>
            </#list>
            </div>
        </div>
    </div>
</div>
