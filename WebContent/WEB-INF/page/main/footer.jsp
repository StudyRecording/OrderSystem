<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$("img").mouseover(function(){
					$("img").attr("src","/ordersystem/img/github-w.png");
				});
				
				$("img").mouseout(function(){
					$("img").attr("src","/ordersystem/img/github-d.png");
				})
				
			})
		</script>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			#footer_div{	
				width: 100%;
			}
			
			#my_info{
				color: white;
				font-size: 15px;
				margin-top: 10px;
				margin-left: 10px;
			}
			#myblog{
				color: white;
				font-size: 15px;
				margin-top: 10px;
				margin-left: 300px;
				text-decoration: none;
			}
			img{
				
				width: 23px;
				height: 23px;
				position: relative;
				top:4px;
				left: 500px;
			}
			
			
		</style>
	</head>
	<body style="background-color: #2F4056;">
		<div id="footer_div">
			
			<span id="my_info">胡鹏成 201601450101 JSP期末项目</span>
			<span ><a id="myblog" href="https://blog.csdn.net/qq_37296487" style="color: white;" target="_blank">我的博客</a></span>
			
			<a href="https://github.com/StudyRecording" target="_blank"><img src="/ordersystem/img/github-d.png"></a>
		</div>
		
	</body>
</html>