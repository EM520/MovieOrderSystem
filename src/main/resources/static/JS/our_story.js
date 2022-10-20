/**
 * 
 */
const body =document.querySelector("body");

// // create dark/light mode 
const darkmode = document.querySelector("#darkmode");
const lightmode = document.querySelector("#lightmode");

function setDarkMode(e){
    e.preventDefault();
    body.style.background = "#3B3E3F";
    body.style.color = "white";

}

function setLightMode(e){
    e.preventDefault();
    body.style.background = "#FF7518";
    body.style.color = "black";    
}

lightmode.addEventListener("click",setLightMode);
darkmode.addEventListener("click",setDarkMode);
