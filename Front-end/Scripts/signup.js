let submitbtn= document.querySelector("form");
const url= "http://localhost:8088/VegStore/customerRegister";
submitbtn.onsubmit=(e)=>{
     e.preventDefault();
   
    let name= document.querySelector("#name").value;
    let username= document.querySelector("#username").value;
    let email= document.querySelector("#email").value;
    let phone= document.querySelector("#phone").value;
    let address= document.querySelector("#address").value;
    let password= document.querySelector("#password").value;
    
    let str= address.split("/");
    let addressob= {
                 "flatNo":str[0],
                 "buildingName":str[1],
                 "area":str[2],
                 "city":str[3],
                 "state":str[4],
                 "pincode":str[5]
    };
    let ob= {
           "userName":username,
           "email":email,
           "password":password,
           "phone":phone,
           "role":"Customer",
           "name":name,
           "address":addressob
            
    }

    signupdata(url,ob);  
    console.log("working");

    document.querySelector("#username").value="";
    document.querySelector("#email").value="";
    document.querySelector("#phone").value="";
    document.querySelector("#address").value="";
     document.querySelector("#password").value="";
   

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