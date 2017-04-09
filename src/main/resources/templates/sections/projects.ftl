<div class="container" id="i18_projects">
    <div class="row m-b-lg">
        <div class="col-lg-12 text-center">
            <div class="navy-line"></div>
            <h1><span data-i18n="projects.my_projects">My Projects</span></h1>
        </div>
    </div>
    <div class="row">
        {% for project in site.data.projects %}
            {% assign loopindex = forloop.index | modulo: 2 %}
            {% if forloop.last %}
                {% if forloop.last == forloop.first %}
            <div class="col-sm-6 wow col-sm-offset-3 zoomIn">
                {% else %}
            <div class="col-sm-6 wow {% if loopindex == 1 %} fadeInLeft col-sm-offset-3 {% else %} fadeInRight {% endif %}">
                {% endif %}
            {% else %}
            <div class="col-sm-6 wow {% if loopindex == 1 %} fadeInLeft {% else %} fadeInRight {% endif %}">
            {% endif %}
              <div class="team-member">
                  <img src="{{ project.img | prepend: site.baseurl }}" class="img-responsive img-circle img-small" alt="">
                  <h4><a href="{{ project.url}}" target="blank"><span class="navy">{{ project.name }}</a></span></h4>
                  <p><span data-i18n="projects.{{ project.i18n }}">{{ project.desc }}</span></p>
<!--                   <ul class="list-inline">
                      <li>
                          <a class="github-button" href="{{ project.url | prepend: 'https://github.com'}}" data-icon="octicon-star" data-count-href="{{ project.url | append: '/stargazers' }}" data-count-api="{{ project.url | prepend: '/repos' | append: '#stargazers_count' }}" data-count-aria-label="# stargazers on GitHub" aria-label="Star hydepress/jekyll-install on GitHub">Star</a>
                      </li>
                      <li>
                          <a class="github-button" href="{{ project.url | prepend: 'https://github.com'}}" data-icon="octicon-fork" data-count-href="{{ project.url | append: '/network/members' }}" data-count-api="{{ project.url | prepend: '/repos' | append: '#forks_count' }}" data-count-aria-label="# forks on GitHub" aria-label="Star hydepress/jekyll-install on GitHub">Fork</a>
                      </li>
                  </ul> -->
              </div>
          </div>
      {% endfor %}
    </div>
</div>
<br>
