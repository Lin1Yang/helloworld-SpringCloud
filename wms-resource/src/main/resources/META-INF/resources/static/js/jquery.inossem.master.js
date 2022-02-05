//obj定义
/*var obj={
	code:"",//模块编码
	onlyurl:"",//是否是唯一URL，如果是写上URL，如果不是写false
	cilckobj:null,//点的对象
	level:[
		{
			url:"",//当onlyurl==false时起用
			number:"maraCategoryCode",//绑定的编码的字段
			code:"maraCategoryId",//取值的Code的字段
			text:"maraCategoryName",//绑定的名字的字段
			label:"大类",
			children:"middleClassList"
		},
		{
			url:"",//当onlyurl==false时起用
			number:"maraCategoryCodeMiddle",//绑定的编码的字段
			code:"maraCategoryIdMiddle",//取值的Code的字段
			text:"maraCategoryNameMiddle",//绑定的名字的字段
			label:"中类",
			children:"smallClassList"
		},
		{
			url:"",//当onlyurl==false时起用
			number:"maraCategoryCodeSmall",//绑定的编码的字段
			code:"maraCategoryIdSmall",//取值的Code的字段
			text:"maraCategoryNameSmall",//绑定的名字的字段
			label:"小类"
		}
	]
}*/
var modulemaster=function(obj){
	var thisobj=this;
	$.each(obj,function(i,item){
		thisobj[i]=item;
	});
	thisobj.jsonmaster=null;
	thisobj.selectedmenu={
		frist:{menu:-1,data:null},
		second:{menu:-1,data:null},
		third:{menu:-1,data:null}
	};
	
	//写css
	var css=[];
	css.push("<style>");
	css.push(".masterbg"+thisobj.code+"{position:fixed;width: 99%;height:100%;background-color: rgba(255,255,255,0.1);top:0px;left:0px;z-index:1;display: none;}");
	css.push(".master"+thisobj.code+"{background: #fff;width:1000px;position: fixed;display: none;z-index: 1;");
	css.push("box-shadow: #ccc 0px 0px 6px -5px, #ccc 0px 0px 0px, #ccc 3px 3px 3px, #ccc -3px 2px 3px;}");
	css.push(".master"+thisobj.code+" div{min-height:40px;line-height: 40px;white-space: nowrap;text-overflow: ellipsis;overflow: hidden;}");
	css.push("</style>");
	$("head").append(css.join(''));
	
	//写html
	var html=[];
	html.push("<div class='masterbg"+thisobj.code+"'></div>");
	html.push("<div class='master"+thisobj.code+"'>");
	html.push("	<!-- tab标签 -->");
	html.push("	<ul id='myTab"+thisobj.code+"' class='nav nav-tabs'>");
	html.push("		<li class='active'><a href='#mastermenufrist"+thisobj.code+"' data-index='0' data-toggle='tab'>大类</a></li>");
	html.push("		<li><a href='#mastermenusecond"+thisobj.code+"' data-index='1' data-toggle='tab'>中类</a></li>");
	html.push("		<li><a href='#mastermenuthirdly"+thisobj.code+"' data-index='2' data-toggle='tab'>小类</a></li>");
	html.push("	</ul>");
	html.push("	<!-- 每个tab页对应的内容 -->");
	html.push("	<div id='myTabContent"+thisobj.code+"' class='tab-content'>");
	html.push("	   <div class='tab-pane fade in active' id='mastermenufrist"+thisobj.code+"'>");
	html.push("	   </div>");
	html.push("	   <div class='tab-pane fade' id='mastermenusecond"+thisobj.code+"'>");
	html.push("	   </div>");
	html.push("	   <div class='tab-pane fade' id='mastermenuthirdly"+thisobj.code+"'>");
	html.push("	   </div>");
	html.push("	</div>");
	html.push("</div>");
	$("body").append(html.join(''));
	
	if(thisobj.onlyurl!==false){
		$.get(thisobj.onlyurl,function(masterdata){
			thisobj.jsonmaster=(typeof masterdata=='string')?JSON.parse(masterdata):masterdata;
		})
	}
	
	thisobj.show=function(){
		$("#mastermenufrist"+thisobj.code).empty();
		$.each(thisobj.jsonmaster.body,function(i,item){
			$("#mastermenufrist"+thisobj.code).append("<a href='javascript:void(0)' data-value='"+item.maraCategoryId+"' class='col-xs-3'><span class='masternum'>"+item.maraCategoryCode+"</span> <span class='mastertext'>"+item.maraCategoryName+"</span></a>")
			
			$("#mastermenufrist"+thisobj.code+" a:last").data("middleClassList",item.middleClassList);
		});
		
		$(".master"+thisobj.code).css({top:(thisobj.cilckobj.offset().top+32),left:(thisobj.cilckobj.offset().left)}).show();
		$(".masterbg"+thisobj.code).show();
		$(".masterbg"+thisobj.code).unbind("click").click(function(){
			$(".master"+thisobj.code+",.masterbg"+thisobj.code).hide();
		});
		
		$("#myTab"+thisobj.code).on("shown.bs.tab", function(e){
			var index=parseInt($(e.target).attr("data-index"));
			switch(index){
				case 0:{break;}
				case 1:{
					if(thisobj.selectedmenu.frist.menu==-1){
						layer.alert("请选择大类");
						return false;
					}else{
						$("#mastermenusecond"+thisobj.code).empty();
						$.each(thisobj.selectedmenu.frist.data,function(i,item){
							$("#mastermenusecond"+thisobj.code).append("<a href='javascript:void(0)' data-value='"+item.maraCategoryIdMiddle+"' class='col-xs-3'><span class='masternum'>"+item.maraCategoryCodeMiddle+"</span> <span class='mastertext'>"+item.maraCategoryNameMiddle+"</span></a>")
							$("#mastermenusecond"+thisobj.code+" a:last").data("smallClassList",item.smallClassList);
						});
					}
					break;
				}
				case 2:{
					if(thisobj.selectedmenu.second.menu==-1){
						layer.alert("请选择中类");
						return false;
					}else{
						$("#mastermenuthirdly"+thisobj.code).empty();
						$.each(thisobj.selectedmenu.second.data,function(i,item){
							$("#mastermenuthirdly"+thisobj.code).append("<a href='javascript:void(0)' data-value='"+item.maraCategoryIdSmall+"' class='col-xs-3'><span class='masternum'>"+item.maraCategoryCodeSmall+"</span> <span class='mastertext'>"+item.maraCategoryNameSmall+"</span></a>")
						});
					}
					break;
				}
				default:{}
			}
		})
		
		$(document.body).on("click", "#mastermenufrist"+thisobj.code+" a", function(e) {
			thisobj.selectedmenu={frist:{menu:($(this).attr("data-value")),data:($(this).data("middleClassList"))},second:{menu:-1,data:null},third:{menu:-1,data:null}};
			$("#myTab"+thisobj.code+" a").eq(1).click();
			$("#myTab"+thisobj.code+" a").eq(0).html("大类："+$(this).find(".masternum").html()+" "+$(this).find(".mastertext").html()).end().eq(1).html("中类").end().eq(2).html("小类");
		});
		
		$(document.body).on("click", "#mastermenusecond"+thisobj.code+" a", function(e) {
			thisobj.selectedmenu.second.menu=($(this).attr("data-value"));
			thisobj.selectedmenu.second.data=($(this).data("smallClassList"));
			thisobj.selectedmenu.third.menu=-1;
			thisobj.selectedmenu.third.data=null;
			$("#myTab"+thisobj.code+" a").eq(2).click();
			$("#myTab"+thisobj.code+" a").eq(1).html("中类："+$(this).find(".masternum").html()+" "+$(this).find(".mastertext").html()).end().eq(2).html("小类");
		});
		
		$(document.body).on("click", "#mastermenuthirdly"+thisobj.code+" a", function(e) {
			var pageindex=1;
			var pagesize= $.cookie("pageSize" + GetURLKey()) || 20;
			var url="/testDto/findTestByPage?page="+pageindex+"&size="+pagesize+"&maraCategoryCode="+$(this).find(".masternum").html();
			window.localStorage.setItem("type","smallClass");
			$.ajax({url:url,data:null,success: function(data){
				try {if(typeof showsearchresult === "function") { showsearchresult(data);} else {}} catch(e) {}
			},
				dataType: "json"
			});
			thisobj.selectedmenu.third.menu=($(this).attr("data-value"));
			thisobj.selectedmenu.third.data=null;
			window.localStorage.setItem("selectmaraCategoryCode_banner",$(this).find(".masternum").html());
			$("#myTab"+thisobj.code+" a").eq(2).html("小类："+$(this).find(".masternum").html()+" "+$(this).find(".mastertext").html());
			$(".masterbg"+thisobj.code+"").click();
		});
	}
}