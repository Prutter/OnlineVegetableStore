let Customer;
window.onload = function customerdetails() {

  
      
  }


window.onload = function fetchallvegetables() {

  fetch('http://localhost:8088/viewAllVegetableforadmin')
.then(response => response.json())
.then(data => {
  let cards = '';
  data.forEach(product => {
    cards += `
    <div class="card">
      <img src="${product.url}" alt="${product.name}">
      <h3>${product.name}</h3>
      <p>$${product.price}</p>
      <button>Add to Cart</button>
    </div>
    `;
  });
  document.getElementById('cards').innerHTML = cards;
})
.catch(error => console.error(error));






// displaying the address on the navbar

let city = JSON.parse(localStorage.getItem('city'));
document.getElementById("cityaddress").innerText = city;





// getting customer details from localstorage

//  -----------------------------------------Demo-----------------------------------------------------------

// Customer = JSON.parse(localStorage.getItem('customer'));
      
//       document.getElementById("CustomerName").value = Customer.userName;
//       document.getElementById("email").value = Customer.email;
//       document.getElementById("phone").value = Customer.phone;



// let vegetables =  [
// {
//     "name" : "Tomato",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://th.bing.com/th/id/OIP.ZQf_Lffx4PsbyJBuoEXxgAHaHG?pid=ImgDet&rs=1"
// },
// {
//     "name" : "Potato",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://th.bing.com/th/id/OIP.LmnMbxl475cjC_4MRQxvRQHaGl?pid=ImgDet&rs=1"
// },
// {
//     "name" : "Brinjal",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://th.bing.com/th/id/OIP.dWEqqVMDyMMvwKReUQy2IQHaGk?pid=ImgDet&rs=1"
// },
// {
//     "name" : "Carrot",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://media.istockphoto.com/photos/fresh-carrots-isolated-on-white-background-picture-id1087879296?k=6&m=1087879296&s=170667a&w=0&h=495eoEsuqDqM4YBQQOpFiVP7i7r0KptISEHnfpO6AM4="
// },
// {
//     "name" : "Pumpkin",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://torange.biz/photo/35/HD/pumpkin-cut-slice-white-background-piece-35615.jpg"
// },
// {
//     "name" : "Broccoli",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://www.betternutrition.com/wp-content/uploads/sites/8/2019/09/broccoli.jpg"
// },
// {
//     "name" : "Capsicum",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://thumbs.dreamstime.com/b/bell-peppers-capsicum-isolated-white-background-45115387.jpg"
// },
// {
//     "name" : "Carrot",
//     "price" : 12.5,
//     "quantity" : 100,
//     "type" : "daily use",
//     "url" :"https://media.istockphoto.com/photos/fresh-carrots-isolated-on-white-background-picture-id1087879296?k=6&m=1087879296&s=170667a&w=0&h=495eoEsuqDqM4YBQQOpFiVP7i7r0KptISEHnfpO6AM4="
// },

// ]
// localStorage.setItem('vegetables', JSON.stringify(vegetables));

// let veg = JSON.parse(localStorage.getItem('vegetables'));

// let cards = '';
//  veg.forEach(vegs => {
//     cards += `
//     <div class="card">
//       <img src="${vegs.url}" alt="${vegs.name}">
//       <h3>${vegs.name}</h3>
//       <p>$${vegs.price}</p>
//       <button onclick="addingitemtocart()">Add to Cart</button>
//     </div>
//     `;
//   });
//   document.getElementById('rightsection').innerHTML = cards;

}


