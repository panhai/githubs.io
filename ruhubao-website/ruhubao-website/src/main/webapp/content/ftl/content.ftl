<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>博霖教育入户服务咨询中心</title>
    <meta name="description" content="博霖教育后台数据管理" />
    <meta name="keywords" content="博霖教育|学历报考中心|学历提升|广东省成人学历报名中心" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" type="images/x-icon" href="../../img/bolinglink.png">
    <link rel="stylesheet" type="text/css" href="../css/showContent.css"/>
    
	</head>
	<body>
   <div class="app">
    <div class="logo-top">
      <div class="container logo-box">
        <img src="../img/logo.jpg" alt="">
        <a href="../../index.html" style="margin-left: 45px;" class="nv">首页</a>
        <a href="../../ruhu-way/index.html" class="nv">入户方式 </a>
        <a href="policy.html"  class="nv active">入户政策</a>
        <a href="http://www.ruhubao.net/mobile/views/ru.html" class="nv">积分计算</a>
        <a href="https://www.bolinjy.cn/" class="nv">学历提升</a>
        <a href="about.html" class="nv">关于我们</a>
        <a href="contact.html" class="nv">联系我们</a>
      </div>
    </div>
    <div class="content">
      <div class="container">
        <p class="wei">
          <span>您当前所在的位置： 首页 > 入户政策>${title}</span>
        </p>
        <!-- 发布内容 -->
        <div class="pagecontent">
          <h2 class="title">${title}</h2>
          <p class="time">${created}</p>
          <div class="img-box"><img src=${pic} ></div>
          <div class="text-box">
        	 ${content}
          </div>
          
          <div class="recommend">
            <div class="btn">
              <button type="button" title="点击下载" class="layui-btn download">下载</button>
            </div>
            <div>
              <span style="color: #e60000;font-size: 26px;font-weight: 800;margin-right: 6px;">推荐阅读:</span>
              <a href="#">广州市积分制入户管理办法实施细则</a>
            </div>
          </div>
          
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="container copyRight clearfix">
        <div class="left">
          <img src="../img/logo2.jpg" alt="">
          <p class="r">020-82526164</p>
          <p class="f">周一至周日：09：00-18:00</p>
        </div>
        <div class="center">
          <div class="alink">
            <a href="../../index.html" class="nv">首页</a>
            <a href="../../ruhu-way/index.html" class="nv">入户方式</a>
            <a href="http://www.ruhubao.net/mobile/views/ru.html" class="nv">积分计算</a>
            <a  href="https://www.bolinjy.cn/" class="nv">学历提升</a>
            <a href="about.html" class="nv">关于我们</a>
            <a href="contact.html" class="nv">联系我们</a>
          </div>
          <p class="t">地址：广州市天河区车陂加悦大厦十楼1009室</p>
          <div class="copy">
            <span>版权所有©2019  广州博霖教育科技有限公司  备案号：粤ICP备19060809号-3</span>
          </div>
        </div>
        <div class="right">
          <img src="../img/erweima.jpg" alt="">
        </div>
      </div>
    </div>
  </div>
  
  
    
    <script src="../../js/jquery2.01.js"></script>
    <script src="../../ku/layui/layui.all.js "></script>
    <script src="../../js/FileSave.js"></script>
    <script src="../../js/export_world.js"></script>

    <script type="text/javascript">
      
      //接入客服
      $('a').not('.link,.nv').on('click', function() {
        layer.open({
          type: 2,
          area: ['800px', '500px'],
          content: 'https://www16.53kf.com/webCompany.php?arg=10187673&kf_sign=DY5MTMTU1OU4ODExMDc3NTgxNTg4MDA4NzIxODc2NzM%253D&style=1' //这里content是一
        })
      })
      
      
    	  $("button.download").click(function(event) {
            $(".pagecontent").wordExport("new");
        });
    </script>
	</body>
</html>
