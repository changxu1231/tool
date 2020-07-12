function height1() {
    var h = document.documentElement.clientHeight || document.body.clientHeight;
    document.getElementById("img1").style.height=h+"px";
}
function logon() {
    layer.open({
        type: 2,
        title:"注册用户",
        anim: 3,
        skin: 'layui-layer-rim', //加上边框
        area: ['520px', '340px'], //宽高
        content: 'logon'
    });
}
function checkPhone(){
    var phone = document.getElementById('phone').value;
    if(!(/^1[3456789]\d{9}$/.test(phone))){
        // alert("手机号码有误，请重填");
        layer.tips('请检查手机号', '#phone');
        document.getElementById('phone').value=""
    }
}