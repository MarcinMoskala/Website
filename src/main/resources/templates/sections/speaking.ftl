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
            {% for speaking in site.data.speaking %}
            {% assign loopindex = forloop.index | modulo: 2 %}
                <div class="vertical-timeline-block">
                    <div class="vertical-timeline-icon navy-bg wow rotateIn">
                        <i class="fa {{ speaking.icon }}"></i>
                    </div>
                    <div class="vertical-timeline-content wow {% if loopindex == 1 %} rotateInUpRight {% else %} rotateInUpLeft {% endif %}">
                        <h2><a href="{{ speaking.link }}"><span data-i18n="speaking.{{ speaking.name.i18n }}">{{ speaking.name.detail }}</span></a></h2>
                        <p><span data-i18n="speaking.{{ speaking.desc.i18n }}">{{ speaking.desc.detail }} </span></p>
                        <span class="vertical-date"><span data-i18n="speaking.{{ speaking.date.i18n }}"> {{ speaking.date.detail }} </span>
                        <br/> <small><span data-i18n="speaking.{{ speaking.job.i18n }}">{{ speaking.job.detail }}</span></small> </span>
                    </div>
                </div>
            {% endfor %}
            </div>
        </div>
    </div>
</div>
