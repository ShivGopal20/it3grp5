function Store(){
    var Bruger = document.getElementById("InputBrugernavn").value;
    sessionStorage.setItem("Godkendt_Bruger", Bruger);
}

function LoginValidation() {
    let navn = document.getElementById("InputBrugernavn").value;
    let kode = document.getElementById("InputKode").value;
    fetch("rest/Login?" + new URLSearchParams({
        InputKode: kode, InputBrugernavn: navn}
    )).then(resp => {
        if (resp.status!==200){
            alert("Ugyldigt Log-In\nFejlkode: " + resp.status)
        } else {
            resp.text().then(data =>
                Validering(data))

        }
});
}

function Validering(x) {
    localStorage.setItem("token",x)
    window.location.replace("Home.html")
}

