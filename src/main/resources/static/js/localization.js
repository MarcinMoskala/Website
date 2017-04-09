function getQueryParam(param) {
    location.search.substr(1)
        .split("&")
        .some(function(item) { // returns first occurence and stops
            return item.split("=")[0] == param && (param = item.split("=")[1])
        })
    return param
}

function replaceQueryParam(param, newval) {
    var regex = new RegExp("([?;&])" + param + "[^&;]*[;&]?");
    var query = window.location.search.replace(regex, "$1").replace(/&$/, '');
    window.location = window.location.pathname + (query.length > 2 ? query + "&" : "?") + (newval ? param + "=" + newval : '');
}

function quietReplaceQueryParam(param, newval) {
    var regex = new RegExp("([?;&])" + param + "[^&;]*[;&]?");
    var query = window.location.search.replace(regex, "$1").replace(/&$/, '');
    history.pushState({}, null, window.location.pathname + (query.length > 2 ? query + "&" : "?") + (newval ? param + "=" + newval : ''));
}

$(document).ready(function() {
  var i18nOpts = {
    lng: 'en',
    fallbackLng: 'en',
    resGetPath: 'static/locales/__lng__.json'
  };

  var translate = function() {
    $('.i18container').i18n();
    $('#i18_navbar').i18n();
    $('#i18_about_me').i18n();
    $('#i18_skills').i18n();
    $('#i18_projects').i18n();
    $('#i18_career').i18n();
    $('#i18_speaking').i18n();
    $('#i18_blog').i18n();
    $('#i18_link').i18n();
  };

  $("[id^=set_lang]").each(function() {
    var $this = $(this);
    $this.on('click', function() {
      var lang = $this.data('locale')
      i18n.setLng(lang, translate);
      quietReplaceQueryParam('l', lang);
    });
  });

  $.i18n.init(i18nOpts, translate);

  var queryLang = getQueryParam('l');
  if(queryLang !== null) {
    i18n.setLng(queryLang, translate);
  }
});
