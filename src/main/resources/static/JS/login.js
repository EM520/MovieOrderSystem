const formreg = document.querySelector("#form2");
const formlog = document.querySelector("#form1");
const username = document.querySelector("#username");
const usernamelogin = document.querySelector("#usernamelogin");
const email = document.querySelector("#email");
const password = document.querySelector("#password");
const passwordlogin = document.querySelector("#passwordlogin");
const password2 = document.querySelector("#password2");

formlog.addEventListener("submit", (e) => {
  e.preventDefault();
  logvalidateInputs();
});



  const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector(".error");
    errorDisplay.innerText = message;
    inputControl.classList.add("error");
    inputControl.classList.remove("success");
  };
  
  const setSuccess = (element) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector(".error");
    errorDisplay.innerText = "";
    inputControl.classList.add("success");
    inputControl.classList.remove("error");
  };

  const logvalidateInputs = () => {
    
    const usernameLoginValue = usernamelogin.value.trim();
    const passwordLoginValue = passwordlogin.value.trim();
    
    if (usernameLoginValue  === "") {
      setError(usernamelogin, "Username is required");
    } else {
      setSuccess(usernamelogin);
    }
  
    if (passwordLoginValue === "") {
      setError(passwordlogin, "Password is required");
    } else if (passwordLoginValue.length < 8) {
      setError(passwordlogin, "Password must be at least 8 character.");
    } else {
      setSuccess(passwordlogin);
    }

};

formreg.addEventListener("submit", (e) => {
  e.preventDefault();
  regvalidateInputs();
});

const isValidEmail = (email) => {
  const reg =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return reg.test(String(email).toLowerCase());
};

  const regvalidateInputs = () => {
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();
    
  
    if (usernameValue === "") {
      setError(username, "Username is required");
    } else {
      setSuccess(username);
    }
  
    if (emailValue === "") {
      setError(email, "Email is required");
    } else if (!isValidEmail(emailValue)) {
      setError(email, "Provide a valid email address");
    } else {
      setSuccess(email);
    }

    if (passwordValue === "") {
      setError(password, "Password is required");
    } else if (passwordValue.length < 8) {
      setError(password, "Password must be at least 8 character.");
    } else {
      setSuccess(password);
    }
    if (password2Value === "") {
      setError(password2, "Please confirm your password");
    } else if (password2Value !== passwordValue) {
      setError(password2, "Passwords doesn't match");
    } else {
      setSuccess(password2);
    }
   
};
