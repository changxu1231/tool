//查看功能
function viewCode(s,t) {
    // 获取方法名
    var m1 = 'm'+s;
    var method = document.getElementById(m1).value;
    var methodName = method + "功能演示";
    //弹出要查看的代码
    var s1 = "x" + s;
    if(t == null || t == ""){
        t = "error";
    };
    layui.use('layer', function () {
        layer.open({
            type: 2,
            title: [methodName, 'font-size:18px;color:red'],
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '440px'], //宽高
            // content: $("#" + s1).html()
            content:"html/show/"+t+".html"
        });
    });
}
//复制功能
function copyNow(s) {
    var s1 = "x" + s;
    document.getElementById(s1).style.display = "block";
    var text = $('#' + s1);
    text.select();
    document.execCommand("Copy")
}
//关闭功能
function f1(s) {
    var s1 = "x" + s;
    document.getElementById(s1).style.display = "none"
}
//重置
function reset1() {
    document.getElementById("downtime").value="";
}
