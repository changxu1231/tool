var firstAjax = function (s) {
    var f1 = document.getElementById('first' + s).value;
    var s2 = document.getElementById('second' + s).value;
    var t3 = document.getElementById('third' + s).value;
    var f11 = document.getElementById('f' + s).value;
    var s22 = document.getElementById('s' + s).value;
    var t33 = document.getElementById('t' + s).value;
    if (f1 != f11 || s2 != s22 || t3 != t33) {
        $.ajax({
            type: "post",
            url: "/firstAjax",
            data: $("#myForm" + s).serialize(),
            success(data) {
                window.location.reload(true)
            }
        })
    }
}

function show() {
    document.getElementById("images1").src = "images/tool/b1.jpg";
    document.getElementById("images1").style = "cursor:pointer";
    document.getElementById("di").style.display = "block"
}

function hide() {
    document.getElementById("images1").src = "images/tool/b2.jpg";
    document.getElementById("di").style.display = "none"
}

function addBian() {
    layui.use('layer', function () {
        layer.open({
            type: 2,
            title: ["添加爱心便签", "font-size:18px;color:red"],
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '440px'], //宽高
            // content: $("#" + s1).html()
            content: "html/show/addBian.html"
        });
    });
}

function deleteAll() {
    var ids = "";
    $('input:checkbox').each(function () {
        if (this.checked == true) {
            ids += this.value + ',';
        }
    });
    layer.confirm("请问是否确定删除，删除后不可恢复!", {
        icon: 7, title: "警告"
    }, function (index) {
        $.ajax({
            type: "POST",
            url: "deleteFirst",
            data: {
                ids: ids
            },
            success(data) {
                if (data == "SUCCESS") {
                    layer.close(index);
                    layer.msg("删除成功", {icon: 1, time: 2000});
                    var int = self.setInterval(function () {  // 这个方法是说在延迟两秒后执行大括号里的方法
                        parent.location.reload();//刷新页面
                    }, 1000)
                } else {
                    layer.close(index);
                    alert("至少选择一项")
                }
            }
        })
    }, function () {
    });
}

function imgs(i) {
    var i1 = "i" + i;
    var a = document.getElementById(i1).src;
    if (a == "http://localhost:8080/images/tool/e1.png") {
        document.getElementById(i1).src = "images/tool/e2.png";
        document.getElementById("btna").style.display = "block"
    } else {
        document.getElementById(i1).src = "images/tool/e1.png";
    }
}

function testButton() {
    var ids = "";
    $('input:checkbox').each(function () {
        if (this.checked == true) {
            ids += this.value + ',';
        }
    });
    if (ids == null || ids == "") {
        document.getElementById("btna").style.display = "none"
    }
}

function tiao() {
    window.location.href = "/homePage"
}

function tiao1() {
    window.location.href = "/"
}
