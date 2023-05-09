let addressbtn= document.querySelector("#address-page form");
let addressbarEnableButtton= document.querySelector("#address-btn");

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
      
      }
       else 
         {
        document.querySelector("#login-div").style.display="block";
        document.querySelector("#signup-div").style.display="block";
        document.querySelector("#display-div").style.display="none";
       
        document.querySelector("#logout-div").style.display="none";
        document.querySelector("#cart-div").style.pointerEvents="none";
        document.querySelector("#address-btn").style.display="none";

         }


    document.querySelector("#logout-div").onclick = (e)=>{
       e.preventDefault();
       localStorage.setItem("loggedsession",JSON.stringify(false));
       window.location.href="index.html"
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
  
      document.querySelector("#address-page").style.display="none";
      document.querySelector(".main").style.display="block";
      document.querySelector("#submit-btn").disabled=false;
  
  };

};