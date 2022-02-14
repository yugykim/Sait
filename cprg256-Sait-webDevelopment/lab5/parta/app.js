// The meserment id store 
const selectElement = document.querySelector('.measerment-select');
const input = document.querySelector('input');
const number = document.getElementById('number');
const chosenMeserment = document.getElementById('chosenMeserment');
const relatedMesermentChoice = document.getElementById('related-meserment-choice');


selectElement.addEventListener('change', (event) => {

  console.log(event.target.value);
  if (event.target.value == "litter"){
    chosenMeserment.textContent = "Litter"
    relatedMesermentChoice.textContent = "Gallons"
    input.addEventListener('change', (e) => {
      number.textContent = e.target.value * 0.264172;
    });
  } else if (event.target.value == "gallon") {
    chosenMeserment.textContent = "Gallon"
    relatedMesermentChoice.textContent = "Litter"
    input.addEventListener('change', (e) => {
      number.textContent = e.target.value * 3.78541;
    });
  } else if (event.target.value == "metre"){
    chosenMeserment.textContent = "meter"
    relatedMesermentChoice.textContent = "Feet"
    input.addEventListener('change', (e) => {
      number.textContent = e.target.value * 3.28084;
    });
  } else {
    chosenMeserment.textContent = "Feet"
    relatedMesermentChoice.textContent = "Meter"
    input.addEventListener('change', (e) => {
      number.textContent = e.target.value * 0.3048;
    });
  }
});


