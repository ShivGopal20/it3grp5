BrugerFremvsinging();
let i = 1;

function BrugerFremvsinging() {
    Bruger = sessionStorage.getItem("Godkendt_Bruger");
    document.getElementById("Bruger").innerHTML = Bruger;
}

function AftaleOprettelse(){
    let Dato = document.getElementById("dato").value;
    let StartTid = document.getElementById("tid_fra").value;
    let Sluttid = document.getElementById("tid_til").value;
    let CPR = document.getElementById("CPR").value;
    let SP = document.getElementById("SP").value;



    if (Dato != null && StartTid != null && Sluttid != null && CPR.length == 10 && SP != null){
        document.getElementById("Dato"+i).innerHTML = Dato;
        document.getElementById("Starttid"+i).innerHTML = StartTid;
        document.getElementById("Sluttid"+i).innerHTML = Sluttid;
        document.getElementById("CPR"+i).innerHTML = CPR;
        document.getElementById("SP"+i).innerHTML = SP;
        i++;

    } else{
        alert("Indtast venligst alle oplsyninger. ")
    }
}

function Clear(){
    for (){

    }
}
