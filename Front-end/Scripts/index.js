let addressbtn= document.querySelector("#address-page form");
let addressbarEnableButtton= document.querySelector("#address-btn");
let cardEnableButton= document.querySelector("#card-btn");
let cardbtn= document.querySelector("#card-page form");

window.onload = ()=>{
    let customerdetails= JSON.parse(localStorage.getItem("customer"))|| undefined;
    let session= JSON.parse(localStorage.getItem("loggedsession"))|| undefined
    if(session!== undefined && session== true)
      {
        document.querySelector("#login-div").style.display="none";
        document.querySelector("#signup-div").style.display= "none";
        document.querySelector("#display-div").style.display= "block";
        document.querySelector("#display-div>h2").innerText=customerdetails.name;
        document.querySelector("#logout-div").style.display= "block";
        document.querySelector("#cart-div").style.pointerEvents="all";
        document.querySelector("#address-btn").style.display="block";
        document.querySelector("#card-btn").style.display="block";
      
      }
       else 
         {
        document.querySelector("#login-div").style.display="block";
        document.querySelector("#signup-div").style.display="block";
        document.querySelector("#display-div").style.display="none";
       
        document.querySelector("#logout-div").style.display="none";
        document.querySelector("#cart-div").style.pointerEvents="none";
        document.querySelector("#address-btn").style.display="none";
        document.querySelector("#card-btn").style.display="none";

         }

};


document.querySelector("#logout-div").onclick = (e)=>{
  e.preventDefault();
  localStorage.setItem("loggedsession",JSON.stringify(false));
  window.location.href="index.html"
};

cardEnableButton.onclick= ()=>{
 document.querySelector("#card-page").style.display="flex";
 document.querySelector("#main").style.display="none";
};


addressbarEnableButtton.onclick= ()=>{
 document.querySelector("#address-page").style.display="flex";
 document.querySelector("#main").style.display="none";
};


addressbtn.onsubmit=(e)=>{
  e.preventDefault();
  let flatno= document.querySelector("#flatno");
  let bname= document.querySelector("#bname");
  let area= document.querySelector("#area");
  let city= document.querySelector("#city");
  let state= document.querySelector("#state");
  let pcode= document.querySelector("#pcode");

 let addressDetails={
      "area" : area.value,
      "state" :state.value,
      "pincode" : pcode.value,
      "city" :city.value,
      "buildingName" : bname.value,
      "flatNo" :flatno.value
  }

  bname.value="";
  flatno.value="";
  area.value="";
  city.value="";
  state.value="";
  pcode.value="";
  let customerdetails= JSON.parse(localStorage.getItem("customer"))|| undefined;
  const url= `http://localhost:8088/organicoasis/registercustomeraddress/${customerdetails.userId}`;
  addAddress(url,addressDetails);

  document.querySelector("#address-page").style.display="none";
  document.querySelector("#main").style.display="block";
  

};

cardbtn.onsubmit= (e)=>{
  e.preventDefault();
   let cardNo= document.querySelector("#cno");
   let expDate= document.querySelector("#exp-date");
   let walletAmount=document.querySelector("#wamount"); 

   let cardDetails={
    "cardNo" : cardNo.value,
    "expiryDate" :expDate.value,
    "walletAmount" : walletAmount.value
   }
   let customerdetails= JSON.parse(localStorage.getItem("customer"))|| undefined;
   const url= `http://localhost:8088/organicoasis/organicoasis/addcard/${customerdetails.userId}`;
   addCard(url,cardDetails);
   cardNo.value="";
   expDate.value="";
   walletAmount.value="";


  document.querySelector("#card-page").style.display="none";
  document.querySelector("#main").style.display="block";
};

let addAddress= async(url,obj)=>{
  try {
       let res=  await fetch(url,{
        method:"POST",
        headers:{
          "Content-Type":"application/json"
        },
        body:JSON.stringify(obj)
       });
     
       if(res.ok)
        {
          let ans= await res.json();
          alert(`Address ${ans}`);
        }
         else 
          {
             let error= await res.json();
             alert(error.message);
          }

     

  } catch (error) {
    alert("Something went wrong :${error}");
  }
};

let addCard= async (url,obj)=>{

  try {
    let res=  await fetch(url,{
     method:"POST",
     headers:{
       "Content-Type":"application/json"
     },
     body:JSON.stringify(obj)
    });
  
    if(res.ok)
     {
       let ans= await res.json();
       alert("card  added");
       localStorage.setItem("cardWallet",JSON.stringify(ans));
     }
      else 
       {
          let error= await res.json();
          alert(error.message);
       }

  

} catch (error) {
 alert("Something went wrong :${error}");
}

};
