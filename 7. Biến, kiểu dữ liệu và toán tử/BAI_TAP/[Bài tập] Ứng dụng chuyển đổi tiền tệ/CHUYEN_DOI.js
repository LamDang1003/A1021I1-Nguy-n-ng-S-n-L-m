function nhap() {
    let giatrivao = document.getElementById("dauvao").value;
    let select1 = document.getElementById("select1").value;
    let select2 = document.getElementById("select2").value;
    if (select1 == select2){
        alert("giatrivao");
    }
    if (select1 =="a" && select2 =="b"){
        alert(giatrivao/24000);
    }
    if (select1 =="b" && select2 =="a"){
        alert(giatrivao*24000);
    }
}