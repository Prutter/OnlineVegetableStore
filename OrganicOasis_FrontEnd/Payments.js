let customer;


window.onload = function carddetails() {
  
  fetch('http://localhost:8088/organicoasis/getcard/1')
  .then(response => response.json())
  .then(data => {

    document.getElementById("cardnumber").value = data.cardNo;
    document.getElementById("CVV").value = data.cvv;
    document.getElementById("expiry").value = data.expiryDate;
    // document.getElementById("username").value = data.cvv;
 
})
  .catch(error => console.log(error));
    
}

window.onload = function customerdetails() {
  
    fetch('http://localhost:3306/data')
    .then(response => response.json())
    .then(data => {
     customer = data;
      document.getElementById("CustomerName").innerText = data.userName;
      document.getElementById("username").value = data.userName;
      document.getElementById("email").value = data.email;
      document.getElementById("phone").value = data.phone;
      document.getElementById("flatNo").value = data.flatNo;
      document.getElementById("buildingName").value = data.buildingName;
      document.getElementById("area").value = data.area;
      document.getElementById("city").value = data.city;
      document.getElementById("state").value = data.state;
      document.getElementById("pincode").value = data.pincode;

   
  })
    .catch(error => console.log(error));
      
  }

window.onload = function walletdetails() {
  
  
}


// Inserting values to localstorage for testing






  window.onload = function carddetails() {

    let customer = {
      userName: 'Soumit',
      email: 'sd@gmail.com',
      phone: '1234567890',
      address: {
        flatNo: '123',
        buildingName:"Shanti Villa",
        area: 'Shanti Colony',
        city: 'Krishnanagar',
        state: 'West Bengal',
        pincode:'700001'
      }
  };
  localStorage.setItem('customer', JSON.stringify(customer));

  document.getElementById("CustomerName").value = customer.userName;
  document.getElementById("username").value = customer.userName;
  document.getElementById("email").value = customer.email;
  document.getElementById("phone").value = customer.phone;
  document.getElementById("flatNo").value = customer.address.flatNo;
  document.getElementById("buildingName").value = customer.address.buildingName;
  document.getElementById("area").value = customer.address.area;
  document.getElementById("city").value = customer.address.city;
  document.getElementById("state").value = customer.address.state;
  document.getElementById("pincode").value = customer.address.pincode;





//   let cardDetails = {
//     "cvv" : 123,
//     "cardNo" : "123456788765",
//     "expiryDate" :"8/24",
//     "walletAmount" : 3500
// };
//   localStorage.setItem('cardDetails', JSON.stringify(cardDetails));
  
//   cardDetails = JSON.parse(localStorage.getItem('cardDetails'));
  
//       document.getElementById("cardnumber").value = cardDetails.cardNo;
//       document.getElementById("CVV").value = cardDetails.cvv;
//       document.getElementById("expiry").value = cardDetails.expiryDate;
// alert("wallet")

// getting wallet balance

fetch('http://localhost:8088/organicoasis/getcard/1')
.then(response => response.json())
.then(data => {

  document.getElementById("wbalance").value = data.walletAmount;

//   Total value of cart
//   document.getElementById("ctotal").value = data.userName;


})
.catch(error => console.log(error));


}

function paymentsuccess(){

  document.getElementById("paymentsuccessfulbox").style.visibility = "visible";

}

function closepaymentsuccess(){

  document.getElementById("paymentsuccessfulbox").style.visibility = "hidden";
}

function addcashsuccess(){

  document.getElementById("cashAddsuccessfulbox").style.visibility = "visible";

}

function closeaddsuccess(){

  document.getElementById("cashAddsuccessfulbox").style.visibility = "hidden";
  
  let amount = document.getElementById("inputbox").value;
  
  // write code to add amount to wallet balance
  //  uri = http://localhost:8088/orgaincoasis/transaction/1/amount
  fetch('http://localhost:8088/orgaincoasis/transaction/1/amount',{
    method : "POST"
  })
  .then(response => response.json())
  .then(data => {
  
    alert("Amount has been added to your wallet successfully.");
    carddetails();
})

   location.reload();
}
