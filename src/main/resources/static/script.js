// ADD INGREDIENT AND INSTRUCTION

function addExtraIngredientForm() {
  const ingredientForms = document.getElementById('ingredient-forms');
  const count = ingredientForms.getAttribute('ingredient-count');
  console.log(count);
  fetch('/recipe/add-ingredient-fragment?index=' + count)
    .then(response => response.text())
    .then(fragment => {
        var htmlElement = htmlToElement(fragment);
        ingredientForms.appendChild(htmlElement);
        ingredientForms.setAttribute('ingredient-count', parseInt(count) + 1);
    });
}

function removeIngredientForm(e) {
  e.parentElement.parentElement.remove(e.parentElement);
}

function addExtraInstructionForm() {
  const instructionForms = document.getElementById('instruction-forms');
  const count = instructionForms.getAttribute('instruction-count');
  console.log(count);
  fetch('/recipe/add-instruction-fragment?instructionIndex=' + count)
    .then(response => response.text())
    .then(fragment => {
        var htmlElement = htmlToElement(fragment);
        instructionForms.appendChild(htmlElement);
        instructionForms.setAttribute('instruction-count', parseInt(count) + 1);
    });
}

function removeInstructionForm(e) {
  e.parentElement.parentElement.remove(e.parentElement);
}

function htmlToElement(html) {
  const template = document.createElement('template');
  html = html.trim();
  template.innerHTML = html;
  return template.content.firstChild;
}

// IMAGE UPLOAD PREVIEW

const previewImage = (event) => {
  var imageFiles = event.target.files;
  var imageFilesLength = imageFiles.length;

  if (imageFilesLength > 0) {
    var imageSrc = URL.createObjectURL(imageFiles[0]);
    var imagePreviewElement = document.querySelector("#preview-selected-image");

    imagePreviewElement.setAttribute("class", "img-fluid");
    imagePreviewElement.src = imageSrc;
  }




}


