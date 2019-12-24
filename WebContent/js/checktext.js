$(document).ready(function(){
  regEventCheck();
});

function regEventCheck() {
   $("form input").not(":hidden").each(function(){
      $(this).blur(checkFormBase);
      
   });
}

function checkFormBase() { 
   removeAllErr();
   var pass = true;
   $("form input").not(":hidden").each(function(){
         if(isEmpty($(this).val())) {
            showErrMsg(this, '值不能为空');
            pass = false;
         }
   });
   if (pass) {
	   $("form").get(0).onsubmit = function(){return true;};
   } else {
	   $("form").get(0).onsubmit = function(){return false;};
   }
}

function isEmpty(str) {
	if (null == str || undefined == str) {
		return true;
	}
	if ( str == "" || "null" == str || "undefined" == str) 
		return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

var idExt = "_errMsg";// 生成span层的id后缀
/**
 * 在对应id后面错误信息
 * 
 * @param id:需要显示错误信息的id元素
 *            str:显示错误信息
 */
function showErrMsg(obj, str) {

    var spanNew = document.createElement("span");// 创建span
    spanNew.id = obj.name + idExt;// 生成spanid
    
    spanNew.style.color = "red";
    spanNew.appendChild(document.createTextNode(str));// 给span添加内容
    var inputId = obj;
    var nextSib=inputId.nextSibling;
//如果文本框后面有说明如：（请输入整数1~10），则错误提示显示在该说明后面
    if (inputId.nextSibling!=null) {
        nextSib=nextSib.nextSibling;
    }
//////////////////////////////////////
    inputId.parentNode.insertBefore(spanNew, nextSib);// 给需要添加元素后面添加span
    // 提示错误的文本框处获取焦点
    obj.style.backgroundColor='yellow';
}


/**
 * 删除所有的错误提示
 */
function removeAllErr() {
    //清除所有错误信息提示
   
    for ( var i = 0; i < document.forms[0].elements.length; i++) {
        
        var idObject = document.getElementById(document.forms[0].elements[i].name+idExt);
        if (idObject){
            idObject.parentNode.removeChild(idObject);
            document.forms[0].elements[i].style.backgroundColor='';
        }

    }
}