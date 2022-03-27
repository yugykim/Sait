let orderItems = {
  layer: 1,
  roundCakeSize: 0,
  sheetCakeSizeFirst: 0,
  sheetCakeSizeSecond: 0,
  cakeChoice: ""
};

const additionalChoices = {
  "Cream Cheese Icing": 0,
  "Fruit and Almond Topping": 0,
  "Fruit Jam filling": 0
}

function cartAndOrder() {
  document.getElementById("select-container").hidden = true;
  document.getElementById("contact").hidden = false;
  document.getElementById("menu-image-container").hidden = true;
}

function showSizeSelectionOfCake(choice) {
  orderItems.cakeChoice = choice;
  let idNameBychoice = choice.replace(' ', '');
  let min = choice === "Sheet cake"? 30 : 15;
  let max = choice !== "Sheet Cake"? 60 : 30;
  let maxSheetCakeSecondSize = 45;
  
  const cakeSizeSelecting = document.getElementById("cakeSizeSelecting");

  if (choice !== "Sheet cake"){
    cakeSizeSelecting.innerHTML = `<label>${choice}</label><br /><input type="number"
     id="${idNameBychoice}" name="${idNameBychoice}" value="${0}" min="${min}" max="${max}" required />`
  } else {
    cakeSizeSelecting.innerHTML = `<label>${choice}</label><br /><input type="number" 
    id="${idNameBychoice}1" name="${idNameBychoice}1" value="${0}" min="${min}" max="${max}" required />
    <input type="number" id="${idNameBychoice}2" name="${idNameBychoice}2" value="${0}" min="${min}" 
    max="${maxSheetCakeSecondSize}" required />`
  }
}

function updateAdditionalChoice(value) {
  let additionalChoice = value;
  
  if (additionalChoice === "Cream Cheese icing") {
    additionalChoices["Cream Cheese Icing"] += 5;
  } else if (additionalChoice === "Fruit and Almonds Topping") {
    additionalChoices["Fruit and Almond Topping"] += 7;
  } else {
    additionalChoices["Fruit Jam filling"] += 4;
  }

  addAdditionalchoiceInHtml("add-additionalChocie");
}

function addAdditionalchoiceInHtml(htmlLocation) {
  const addChoice = document.getElementById(htmlLocation);
  addChoice.innerHTML = "";

  for (const [key, value] of Object.entries(additionalChoices)) {
    if (value != 0) {
      addChoice.innerHTML += `<p>${key}  $${value}</p>`;
    }
  }
}

function myformSubmit(event) {
  event.preventDefault();
  document.getElementById('order-list').hidden = false;

  let firstName = document.form.firstName.value;
  let lastName = document.form.lastName.value;
  let phoneNumber = document.form.phoneNumber.value;
  let address = document.form.address.value;
  let postalCode = document.form.postalCode.value;
  let mail = document.form.mail.value;

  const orderlist = document.getElementById("order-info");
  const orderCustomerInfo = document.createElement("div");
  orderCustomerInfo.classList.add("ordered-customerInfo");
  orderlist.innerHTML = "";
  orderCustomerInfo.innerHTML += `<p>${firstName}</p><p>${lastName}</p>
  <p>${phoneNumber}</p><p>${mail}</p><p>${address}</p><p>${postalCode}</p>`;

  orderlist.appendChild(orderCustomerInfo);

}

function formCakeSelect(event) {
  console.log("test");
  console.log(orderItems.cakeChoice);
  event.preventDefault();

  if (orderItems.cakeChoice === "Sheet cake"){
    orderItems.sheetCakeSizeFirst = document.form2.Sheetcake1.value;
    orderItems.sheetCakeSizeSecond = document.form2.Sheetcake2.value;
  } else {
    orderItems.roundCakeSize = document.form2.Roundcake.value;
  }
  orderItems.layer = document.form2.layer.value;

  cartAndOrder();
}

function showOrerList() {
  
  let descriptionOfCake = orderItems.cakeChoice + " ";
  let cakePrice = (orderItems.cakeChoice == "Sheet cake")? calculatedSheetCake() : calculatedRoundCake();
  cakePrice = cakePrice % 1 === 0? cakePrice : cakePrice.toFixed(2);
  let totalCakePrice = cakePrice + additionalChoices["Cream Cheese Icing"]+ 
  additionalChoices["Fruit Jam filling"] + additionalChoices["Fruit and Almond Topping"];
  totalCakePrice = totalCakePrice % 1 === 0? Number(totalCakePrice) : Number(totalCakePrice).toFixed(2);
  descriptionOfCake += (orderItems.roundCakeSize === 0)? orderItems.sheetCakeSizeFirst+"cm " + 
  orderItems.sheetCakeSizeSecond+"cm ":orderItems.roundCakeSize+"cm ";
  descriptionOfCake += (orderItems.layer > 1)? "with " + orderItems.layer + " layers" : "with " + orderItems.layer + " layer";
  

  const addCart = document.getElementById("add-cart");
  addAdditionalchoiceInHtml("add-cart");
  addCart.innerHTML += `<p>${descriptionOfCake} $${cakePrice}</p>`
  addCart.innerHTML += `Total:  $${totalCakePrice}</p>`
}

function calculatedSheetCake() {
  let mimimumSizePrice = 18;
  let mimimumSize = 900;
  let finalPriceOfSheetCake = mimimumSizePrice + (((orderItems.sheetCakeSizeFirst 
    * orderItems.sheetCakeSizeSecond) - mimimumSize) * 0.02);

  return finalPriceOfSheetCake + (finalPriceOfSheetCake / 2) * (orderItems.layer - 1);
}

function calculatedRoundCake() {
  let mimimumSizePrice = 15;
  let mimimumSize = 707;
  let singleLyaerRoundCakePrice = (orderItems.roundCakeSize > 15)? ((((orderItems.roundCakeSize 
    * orderItems.roundCakeSize) * 3.14) - mimimumSize) * 0.02) +  mimimumSizePrice : mimimumSizePrice; 
  return singleLyaerRoundCakePrice + (singleLyaerRoundCakePrice / 2) * (orderItems.layer - 1);
}