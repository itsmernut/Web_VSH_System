<!Doctype html>

<html class="html" lang="en-US">
<head>

<script type="text/javascript">
   if(typeof Muse == "undefined") window.Muse = {}; window.Muse.assets = {"required":["jquery-1.8.3.min.js", "museutils.js", "jquery.watch.js", "jquery.musepolyfill.bgsize.js", "webpro.js", "index.css"], "outOfDate":[]};
</script>

<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
<meta name="generator" content="2015.0.0.309" />
<title>Login</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="css/site_global.css?4052507572" />
<link rel="stylesheet" type="text/css" href="css/index.css?4130644769"
	id="pagesheet" />
<!-- Other scripts -->
<script type="text/javascript">
   document.documentElement.className += ' js';
</script>
<script src="js/login.js"></script>
</head>
<body class="museBGSize">

	<div class="clearfix" id="page">
		<!-- group -->
		<div class="clearfix" id="u114-4">
			<!-- content -->
			<p>Damrong</p>
		</div>
		<div class="museBGSize" id="u107">
			<!-- simple frame -->
		</div>
		
		<form class="form-grp clearfix" id="widgetu338" method="post"
			enctype="multipart/form-data" action="scripts/form-u338.php" name="myform">
			<!-- none box -->
			
			<div class="fld-grp clearfix grpelem" id="widgetu351"
				data-required="true">
				<!-- none box -->
				<span class="fld-input NoWrap actAsDiv clearfix grpelem" id="u353-4">
					<!-- content --> <input class="wrapped-input" type="text"
					spellcheck="false" id="widgetu351_input" name="username"
					tabindex="1" /><label class="wrapped-input fld-prompt"
					id="widgetu351_prompt" for="widgetu351_input"><span
						class="actAsPara">Email</span></label>
				</span>
			</div>
			<div class="fld-grp clearfix grpelem" id="widgetu341"
				data-required="true" data-type="email">
				<!-- none box -->
				<span class="fld-input NoWrap actAsDiv clearfix grpelem" id="u342-4">
					<!-- content --> <input class="wrapped-input" type="password"
					spellcheck="false" id="widgetu341_input" name="password" tabindex="2" /><label
					class="wrapped-input fld-prompt" id="widgetu341_prompt"
					for="widgetu341_input"><span class="actAsPara">Password</span></label>
				</span>
			</div>
			<div class="clearfix grpelem" id="u339-4">
				<!-- content -->
				<p>Login...</p>
			</div>
			<div class="clearfix grpelem" id="u349-4">
				<!-- content -->
				<p>Wrong&nbsp; your ID or Password !!</p>
			</div>
			<div class="clearfix grpelem" id="u340-3">
				<!-- content -->
				<p>&nbsp;</p>
			</div>
				<a href="teacher_home.jsp"><input type="button" value="" id="u350-17" onclick="validate()"/></a>
				
			<!-- state-based BG images -->
		</form>
		<div class="verticalspacer"></div>
	</div>
	<div class="preload_images">
		<img class="preload" src="images/u350-17-r.png" alt="" /> <img
			class="preload" src="images/u350-17-m.png" alt="" /> <img
			class="preload" src="images/u350-17-fs.png" alt="" />
	</div>
	<!-- JS includes -->
	<script type="text/javascript">
   if (document.location.protocol != 'https:') document.write('\x3Cscript src="http://musecdn2.businesscatalyst.com/scripts/4.0/jquery-1.8.3.min.js" type="text/javascript">\x3C/script>');
</script>
	<script type="text/javascript">
   window.jQuery || document.write('\x3Cscript src="scripts/jquery-1.8.3.min.js" type="text/javascript">\x3C/script>');
</script>
	<script src="scripts/museutils.js?183364071" type="text/javascript"></script>
	<script src="scripts/jquery.musepolyfill.bgsize.js?4004268962"
		type="text/javascript"></script>
	<script src="scripts/webpro.js?3803554875" type="text/javascript"></script>
	<script src="scripts/jquery.watch.js?71412426" type="text/javascript"></script>
	<!-- Other scripts -->
	<script type="text/javascript">
   $(document).ready(function() { try {
(function(){var a={},b=function(a){if(a.match(/^rgb/))return a=a.replace(/\s+/g,"").match(/([\d\,]+)/gi)[0].split(","),(parseInt(a[0])<<16)+(parseInt(a[1])<<8)+parseInt(a[2]);if(a.match(/^\#/))return parseInt(a.substr(1),16);return 0};(function(){$('link[type="text/css"]').each(function(){var b=($(this).attr("href")||"").match(/\/?css\/([\w\-]+\.css)\?(\d+)/);b&&b[1]&&b[2]&&(a[b[1]]=b[2])})})();(function(){$("body").append('<div class="version" style="display:none; width:1px; height:1px;"></div>');
for(var c=$(".version"),d=0;d<Muse.assets.required.length;){var f=Muse.assets.required[d],g=f.match(/([\w\-\.]+)\.(\w+)$/),k=g&&g[1]?g[1]:null,g=g&&g[2]?g[2]:null;switch(g.toLowerCase()){case "css":k=k.replace(/\W/gi,"_").replace(/^([^a-z])/gi,"_$1");c.addClass(k);var g=b(c.css("color")),h=b(c.css("background-color"));g!=0||h!=0?(Muse.assets.required.splice(d,1),"undefined"!=typeof a[f]&&(g!=a[f]>>>24||h!=(a[f]&16777215))&&Muse.assets.outOfDate.push(f)):d++;c.removeClass(k);break;case "js":k.match(/^jquery-[\d\.]+/gi)&&
typeof $!="undefined"?Muse.assets.required.splice(d,1):d++;break;default:throw Error("Unsupported file type: "+g);}}c.remove();if(Muse.assets.outOfDate.length||Muse.assets.required.length)c="Some files on the server may be missing or incorrect. Clear browser cache and try again. If the problem persists please contact website author.",(d=location&&location.search&&location.search.match&&location.search.match(/muse_debug/gi))&&Muse.assets.outOfDate.length&&(c+="\nOut of date: "+Muse.assets.outOfDate.join(",")),d&&Muse.assets.required.length&&(c+="\nMissing: "+Muse.assets.required.join(",")),alert(c)})()})();
/* body */
Muse.Utils.transformMarkupToFixBrowserProblemsPreInit();/* body */
Muse.Utils.prepHyperlinks(true);/* body */
Muse.Utils.initWidget('#widgetu338', function(elem) { new WebPro.Widget.Form(elem, {validationEvent:'submit',errorStateSensitivity:'high',fieldWrapperClass:'fld-grp',formSubmittedClass:'frm-sub-st',formErrorClass:'frm-subm-err-st',formDeliveredClass:'frm-subm-ok-st',notEmptyClass:'non-empty-st',focusClass:'focus-st',invalidClass:'fld-err-st',requiredClass:'fld-err-st',ajaxSubmit:true}); });/* #widgetu338 */
Muse.Utils.fullPage('#page');/* 100% height page */
Muse.Utils.showWidgetsWhenReady();/* body */
Muse.Utils.transformMarkupToFixBrowserProblems();/* body */
} catch(e) { if (e && 'function' == typeof e.notify) e.notify(); else Muse.Assert.fail('Error calling selector function:' + e); }});
</script>
</body>
</html>