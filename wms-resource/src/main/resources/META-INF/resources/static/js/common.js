$(function(){
	
	if($("[i-template='head']").length>0){
		$.get("../template/head.html",function(data){
			if(navigator.userAgent.indexOf("Firefox") > -1){
				setTimeout(function(){drawhead(data)},1);
			}else
				drawhead(data);
		});
		$("head").append("<link href='../../../css/jquery-autocomplete.min.css' rel='stylesheet' />");
		$("head").append("<script src='../../../js/jquery-autocomplete.min.js'></script>");
		$("head").append("<script src='../../../js/jquery.cookie.js'></script>");
		$("head").append("<script src='../../../js/jquery.cookie.js'></script>");
	}
	
	$("head").append("<script src='../../../js/jquery-bootstrap-pagination.js'></script>");
	$("head").append("<script src='../../../js/datetimepicker.js'></script>");

	//iframe点取消
	$(".btn_iframe_close_window").click(function() {
		parent.layer.close(parseInt(parent.$(".layui-layer-iframe").attr("times")));
	});
});

function drawhead(data){
	$("[i-template='head']").before(data)
	$("[i-template='head']").remove();
	if($("[i-template='toolbar']").length>0){
		$(".toolbar .container").html($("[i-template='toolbar']").html());
		$("[i-template='toolbar']").remove();
	}
	try {if(typeof loadcompleted === "function") { loadcompleted();} else {}} catch(e) {}
}

var CApp = {
	initBase: function(name, data) {
		var nodes = [
			["span", "div", "th", "td", "b", "h1", "h2", "h3", "h4", "h5"],
			["textarea", "select"],
			["input"]
		];
		var appblock = $("[c-app='" + name + "']");
		var appmodels = appblock.find("[c-model]");
		appmodels.each(function(i, item) {
			var curr = $(this);
			var nodeName = $(this)[0].nodeName.toLowerCase();
			var nodeType = $(this)[0].type.toLowerCase();
			if(nodes[0].indexOf(nodeName) > -1) {
				curr.html(formartNullString(data[curr.attr("c-model")]));
			}
			if(nodes[1].indexOf(nodeName) > -1) {
				curr.val(data[curr.attr("c-model")]);
				curr.change(function(){
					data[curr.attr("c-model")]=curr.val();
				});
			}
			if(nodes[2].indexOf(nodeName) > -1) {
				if(nodeType=="checkbox"){
					if(data[curr.attr("c-model")]==true)
						curr.prop("checked","checked");
					else
						curr.removeAttr("checked");

					curr.change(function(){
						data[curr.attr("c-model")]=curr.is(":checked");
					});
				}else{
					curr.val(data[curr.attr("c-model")]);
					curr.change(function(){
						data[curr.attr("c-model")]=curr.val();
					});
				}
			}
		});
	}
}


function ajax(url, type, data, successcallback, errorcallback,isalert) {
	if(typeof data==='object')
		data=JSON.stringify(data);
	errorcallback = successcallback || function() {};
	$.ajax({
		type: type,
		url: url,
		xhrFields: {
			withCredentials: true
		},
		crossDomain: true,
		data: data,
		contentType: "application/json",
		dataType:'json',
		success: function(data) {
			var isError = false;
			if(data.head != undefined) {
				if(isalert==undefined){//不赋值错误的时候Alert提示
					if(!data.head.status){
						isError=true;
						layer.alert(data.head.msg, {
							icon: 5,
							title: "操作失败",
							end: function(index, layero) {
								layer.close(index);
								errorcallback(data);
							}
						});
					}
				}
				
				if(isalert===true){//赋值true时对错都提示。所以想要提示这个加个ture就行了	
					isError=true;
					if(data.head.status){
						layer.alert(data.head.msg, {
							title: "信息",
							end: function(index, layero) {
								layer.close(index);
								successcallback(data);
							}
						});
					}else{
						layer.alert(data.head.msg, {
							icon: 5,
							title: "操作失败",
							end: function(index, layero) {
								layer.close(index);
								errorcallback(data);
							}
						});
					}
				}
			}
			if(isError == false)
				successcallback(data);
		},
		error: function(xhr, textStatus, errorThrown) {
			console.log("error:" + xhr.status + "__" + textStatus);
			if(xhr.status == 401) {
				layer.alert("请重新登录", {
					icon: 5,
					title: "操作失败",
					end: function(index, layero) {
						location.href = uriapi + "/login.html?url=" + escape(location.href);
						layer.close(index);
					}
				});
			}
			if(xhr.status == 403) {
				if(location.href.indexOf("index.html") == -1)
					location.href = uriapi + "/index.html";
			} else if(xhr.status == 500) {
				layer.alert("数据错误", {
					icon: 5,
					title: "操作失败"
				});
			} else if(xhr.status == 404) {
				layer.alert("404", {
					icon: 5,
					title: "操作失败"
				});
			} else {
				layer.alert("数据错误，请尝试重试登录", {
					icon: 5,
					title: "操作失败"
				});
			}
			errorcallback(textStatus)
		}
	});
}

function $m(m){return $("[c-model='"+m+"']");}

var indexloading=-1;
function showloading() {
	$("input").blur()
	indexloading = layer.load(3, {
		shade: [0.4, '#000']
	});
}

function layerclose(){
	layer.close(indexloading)
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}

//基于JS原型数组的删除
Array.prototype.delete = function(n) {　
	if(n < 0)
		return this;　
	else
		return this.slice(0, n).concat(this.slice(n + 1, this.length));
}

function GetURLKey(){
	return "page"+location.href.split('.html')[0].replace(/\//gm,'').split('.').join("").split(':').join("");
}

function showPage() {
	$.cookie("pageSize" + GetURLKey(), $(".showPage").val())
	search()
}

// 初始化分页
function initPagination(total, current) {
	$("#J_ListPagination").unbind().pagination({
		total_pages: total,
		current_page: current,
		is_number: true,
		callback: function(event, page) {
			search(page);
		}
	});
}

function layersMoretips(tips, el) {
	var index = layer.tips(tips, el, {
		tips: [2, '#f7b824'],
		tipsMore: true,
		time: 5000
	});
	return index;
}

function bindDatePicker(panel) {
	var txtdate = null;

	if(panel == undefined) {
		txtdate = $('.txtdatepicker');
	} else {
		txtdate = panel.find('.txtdatepicker');
	}

	txtdate.each(function() {
		var pos = $(this).attr("data-pickerPosition") == undefined ? "" : $(this).attr("data-pickerPosition");
		$(this).datetimepicker({
			language: 'zh-CN',
			minView: 2,
			weekStart: 1,
			todayBtn: 1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
			pickerPosition: pos,
		});
	});
}

function banner_show(maraCategoryCode){
	ajax('/maraCategory/queryMaraCategoryBycode?maraCode='+maraCategoryCode,'get',null,
		function(data){
			$("ol.breadcrumb").append("<span style='color: white;padding: 0px 12px;font-weight: 600;'>"+data.body.indataMaraCategoryBig.maraCategoryCode+" "+data.body.indataMaraCategoryBig.maraCategoryName+" > "+data.body.indataMaraCategoryMiddel.maraCategoryCode+" " + data.body.indataMaraCategoryMiddel.maraCategoryName +" > "+data.body.indataMaraCategorySmall.maraCategoryCode +" "+data.body.indataMaraCategorySmall.maraCategoryName+"</span>");
		},function(e){

		}
		, 1)
}