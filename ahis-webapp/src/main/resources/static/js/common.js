
function pageNavById(id) {
   self.location='/g/' + id.toLowerCase() + '/index';
}

function pageNavOnLogin(id) {
   self.location='/m/' + id.toLowerCase() + '/index';
}

function goBack(path){
   if(path){
      self.location=path;
   }
   else {
      window.history.back(-1);
   }
}

// 提示框（基于jquery）
(function ($) {
	var my_toast_plug_name = "mytoast";
	$[my_toast_plug_name] = function(options){
		var defaults = {text: "", type: "success"};
		var settings = $.extend( {}, defaults, options );
		var jq_toast = $("<div class='my-toast'><div class='my-toast-icon'></div><div class='my-toast-text'></div></div>");
		var jq_icon = jq_toast.find(".my-toast-icon");
		var jq_text = jq_toast.find(".my-toast-text");
		jq_text.html(settings.text);
		jq_icon.addClass("my-toast-"+settings.type);
		jq_toast.appendTo($("body")).stop().fadeIn(500).delay(3000).fadeOut(500);
		var w = jq_toast.width()-jq_icon.width()-10;
		jq_text.width(w+10);
		var l = -jq_toast.outerWidth()/2;
		var t = -jq_toast.outerHeight()/2;
		jq_toast.css({"margin-left": l+"px", "margin-top": t+"px"});
		var _jq_toast = jq_toast;
		setTimeout(function (){
			_jq_toast.remove();
		}, 10*1000);
	};
}( jQuery ));
function showToastMsg(content, type) {
    $.mytoast({
        text: content,
        type: type
    });
}
function showErrorToast(content) {
    showToastMsg(content, "error");
}
function showNoticeToast(content) {
    showToastMsg(content, "notice");
}
function showSuccessToast(content) {
    showToastMsg(content, "success");
}
function showWarningToast(content) {
    showToastMsg(content, "warning");
}

/**
 * ajax提交
 * @returns
 */
function postAjax(urlpath, params, callback) {
    $.ajax({
        type:"POST",
        url:urlpath,
        data:params,
        async: false,
        success:function(data){
            callback(data);
        },
        error:function(e) {
            alert("出错："+e);
        }
    });
}
