let date = new Date();
let currentDate = date.toISOString().slice(0, 10);

let submitData = {
  clientName: "",
  dateTime: currentDate,
  address: "",
  postalcode: "",
  phoneNumber: "",
  phoneMethod: "",
  email: "",
  shippingMethod: "",
  vegetable: 0,
  pork: 0,
  fruit: 0,
  chicken: 0,
};



function updateData(value, id) {
  if (id === "address" || id === "phoneNumber" || id === "phoneMethod" || id === "shippingMethod"
    || id === "vegetable" || id === "pork" || id === "fruit" || id === "chicken"
    || id === "clientName" && /[a-zA-Z]/i.test(value)
    || id === "postalCode" && /[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]/i.test(value)
    || id === "email" && /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/i.test(value)) {
    submitData[id] = value;
    console.log("valid")
    document.getElementById('invalidInput').hidden = true;
  } else {
    console.log("invalid");
    document.getElementById('invalidInput').hidden = false;
  }
}

function showCart() {
  document.getElementById('showAdd').hidden = false;

  setTimeout(() => {
    document.getElementById('showAdd').hidden = true;
  }, 1000);
  //Prevent natural behaviour

}

function calculateOrder() {
  let totalPrice = submitData.chicken * 7.00 + submitData.vegetable * 30.00 + submitData.fruit * 20.00 + submitData.pork * 5.00;
  totalPrice = totalPrice.toFixed(2);
  document.getElementById('result').hidden = false;
  const resultOrder = document.getElementById('resultOrder');
  const resultTotal = document.getElementById('resultTotal');
  resultOrder.innerHTML = "";
  for (const [key, value] of Object.entries(submitData)) {
    if (value != 0) {
      resultOrder.innerHTML += `${key} : ${value} <br /><br />`;
    }
  }
  resultTotal.innerHTML = `<p>Total Order: $${totalPrice}</p>`

}

function myFormSubmit(event) {
  event.preventDefault();

  let address = document.myForm.address.value;

}