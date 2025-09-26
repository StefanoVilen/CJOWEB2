"use strict";

window.onload = initPage;

function initPage(){
  const form = document.getElementById('form1');
  form.noValidate = true;
  form.addEventListener('submit', function(e){
    const valid = processValidity(this);
    if(!valid) e.preventDefault();
  });
}

function processValidity(form){
  validatePassword(form);
  return applyValidity(form);
}

function applyValidity(form){
  let valid = true;
  let count = 0;
  const elements = form.elements;
  for(let i = 0; i < elements.length - 1; i++){
    const element = elements[i];
    const span = document.getElementById(i);
    if(!element.validity.valid){
      span.innerHTML = element.validationMessage;
      count++;
    } else {
      span.innerHTML = "";
    }
  }
  if(count > 0) valid = false;
  return valid;
}

function validatePassword(form){
  const password = document.getElementById('password');
  const confirmPassword = document.getElementById('confirmPassword');
  if(password.value !== confirmPassword.value){
    password.setCustomValidity('Os valores dos campos de senha e confirmação de senha são diferentes.');
  } else {
    password.setCustomValidity('');
  }
}
