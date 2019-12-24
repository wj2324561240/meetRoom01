function delcfm() {
    //return window.confirm("确定删除该数据吗？");
	var msg = "您真的确定要删除吗？\n\n请确认！";
    if (confirm(msg)==true){
    	return true;
    }else{
    	return false;
    }
}