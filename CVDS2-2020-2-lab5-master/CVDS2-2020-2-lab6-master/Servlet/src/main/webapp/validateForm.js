/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateForm() {
    var x = document.getElementById("idNumber").value;
    if (isNaN(x)) {
        alert("El valor ingresado no es un numero.");
        return false;
    }
}