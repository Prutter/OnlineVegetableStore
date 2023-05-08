let submitbtn= document.querySelector(".form>form");
let addressbtn= document.querySelector("#address-page form");
let addressbarEnableButtton= document.querySelector("#address-btn");
var addressDetails ={};

addressbarEnableButtton.onclick= ()=>{
    document.querySelector("#address-page").style.display="flex";
    document.querySelector(".main").style.display="none";
};

const url= "http://localhost:8088/VegStore/customerRegister";
submitbtn.onsubmit=(e)=>{
     e.preventDefault();
   
    let name= document.querySelector("#name").value;
    let username= document.querySelector("#username").value;
    let email= document.querySelector("#email").value;
    let phone= document.querySelector("#phone").value;
    let password= document.querySelector("#password").value;
    
    
    
    let ob= {
           "userName":username,
           "email":email,
           "password":password,
           "phone":phone,
           "role":"Customer",
           "name":name,
          
            
    }

    signupdata(url,ob);  
    console.log("working");
    document.querySelector("#submit-btn").disabled=true;
    document.querySelector("#name").value="";
    document.querySelector("#username").value="";
    document.querySelector("#email").value="";
    document.querySelector("#phone").value="";
    document.querySelector("#address").value="";
     document.querySelector("#password").value="";
     window.location.href="login.html";
    
   

};


addressbtn.onsubmit=(e)=>{
    e.preventDefault();
    let flatno= document.querySelector("#flatno");
    let bname= document.querySelector("#bname");
    let area= document.querySelector("#area");
    let city= document.querySelector("#city");
    let state= document.querySelector("#state");
    let pcode= document.querySelector("#pcode");

    addressDetails={
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

let signupdata= async (url,ob)=>{
    try {
         let res = await fetch(url,{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(ob)
         });
          
         if(res.ok)
        {
         let ans= await res.json();
         localStorage.setItem("customer",JSON.stringify(ans));
         alert("Registration successful welcome"+ans.name);

        }
        else
        {
        let error= await res.json();
         console.log(error);
         
        
         alert("Something Went wrong");
        }
    } catch (error) {
        alert(error);
    }
};