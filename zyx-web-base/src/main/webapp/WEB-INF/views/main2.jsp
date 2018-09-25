<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>100教育Hippo教材管理系统</title>
<meta name="description" content="100教育Hippo教材管理系统。">
<!-- you could change the very jquery according by your system's need.  -->
<link href="${resourcesBaseUrl}/static/css/login/public.css" type="text/css" rel="stylesheet"/>
<link href="${resourcesBaseUrl}/static/css/login/login.css" type="text/css" rel="stylesheet"/>
<script src="http://res.udb.duowan.com/lgn/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<!-- include udb sdk js , and it depends on jquery.js -->
<script type="text/javascript" src="http://res.udb.duowan.com/lgn/js/oauth/udbsdk/pcweb/udb.sdk.pcweb.popup.min.js"></script>
<script type="text/javascript" src="${resourcesBaseUrl}/static/js/login/login.js"></script>
<!-- <script type="text/javascript" src="http://res.udb.duowan.com/lgn/js/oauth/udbsdk/mobile/udb.sdk.mobile.embedin.min.js"></script> -->
<script type="text/javascript">
 //sdk模式登录的要点在于：
 //①响应用户登录请求事件，唤醒udb请求登录，在唤醒中需要通信udb，获取a.请求token，b.登录url；
 	//见http://cookie.yy.com/duowan_q/wakeudblogin , 其实现类是WakeUDBLoginServlet.java
 //②响应用户登录成功回调事件，在响应中需要通信udb，获取a.访问token，b.用户信息，c.写cookie连接（可完成写公共域cookie）；
 	//见http://cookie.yy.com/duowan_q/udbcallback , 其实现类是UDBCallbackServlet.java
 function sdklogin() {
	 UDB.sdk.PCWeb.popupOpenLgn('/a/lgn/wakeudblogin.do');
 }
 
 //删除cookie的要点在于：
 //①获取到删除cookie的连接；
 //②调用UDB.sdk.PCWeb.deleteCrossmainCookieWithCallBack；
 //③在②的callback中跳转；
 //注：
 //①关于具体如何到达删除cookie，是自己系统而定，这里只是给出一个简单样例，便于展示；
 //②在真实系统中，您也可以直接将删除cookie融合到您的退出操作中，在您退出的后台动作中，发出删除cookie的请求，参考udbcallbackServlet的写cookie模式；

	function deleteCookie() {
		var getDelCookieURL = '/lgn/getDelCookieURL.do';
		$.post(
			getDelCookieURL,
			function(data) {
				if ("1" == data.success) {
					UDB.sdk.PCWeb
							.deleteCrossmainCookieWithCallBack(
									data.delCookieURL,
									function() {
										alert('delete cookie done.you could refresh or redict.');
										top.location.href = "/a/lgn/index.do";
									});
				} else {
					alert(data.errMsg);
				}
			}, "json");
	}
	
	function loginByCookie(){
		var loginByCookieUrl = "/a/lgn/loginByCheckCookie.do"
		$.post(
			loginByCookieUrl,
			function(data) {
				if(data.success=="1"){
					window.location.href = "/";
				}else{
					alert(data.errMsg);
					sdklogin();
				}
			}, "json");
	}
</script>
</head>
<body>
 <div class="login_head" style="width:380px;margin:12px auto;">
    <img class="fl" src="http://static.100.com/image/indexk12/logo.png" alt="100教育Hippo教材管理系统">
    <h1 class="fl">100教育Hippo教材管理系统</h1>
  </div>

<div id='login_info'></div>
<script type="text/javascript">

	$(function(){
		 if(window.parent.document.getElementById("logout")){
		   	  window.parent.location = '/lgn/index.do';
		  }
		var username = UDB.sdk.PCWeb.getCookieVal("username");
		if(!(username=="")) {
			loginByCookie();
		}else{
			setTimeout("udblogin()",200); 
		}
	
	})
</script>
</body>
</html>