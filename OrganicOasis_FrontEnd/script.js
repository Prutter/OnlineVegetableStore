// Mobile menu toggle
const menuToggle = document.querySelector('.menu-toggle');
const navigation = document.querySelector('.navigation');

menuToggle.addEventListener('click', () => {
	navigation.classList.toggle('active');
});
// Get the cart button and popup
var cartBtn = document.getElementById("cart-btn");
var cartPopup = document.getElementById("cart-popup");

// When the user clicks on the cart button, show the popup
cartBtn.onclick = function() {
  cartPopup.style.display = "block";
}

// When the user clicks on the close button or outside the popup, close it
window.onclick = function(event) {
  if (event.target == cartPopup || event.target.classList.contains("close")) {
    cartPopup.style.display = "none";
  }
}

// Add items to the cart popup
function addToCart(itemName, itemPrice) {
  var cartItems = document.getElementById("cart-items");
  var cartItem = document.createElement("li");
  cartItem.innerHTML = itemName + " - $" + itemPrice;
  cartItems.appendChild(cartItem);
}
