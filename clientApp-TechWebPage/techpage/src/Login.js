import React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import axios from 'axios';
import { withRouter } from "react-router";
import { useHistory } from "react-router-dom";

function Login(props) {
    const history = useHistory();
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const login = async () => {

        const params = new URLSearchParams();
        params.append('username', email);
        params.append('password', password);
        axios.defaults.headers.post['Content-Type'] ='application/x-www-form-urlencoded';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        axios.post(`http://localhost/login`, params)
      .then(res => {
        console.log(res);
        localStorage.setItem("techWebToken", res.data.replace("\n", ""))
        history.push("/tech")
      }).catch(err => console.log(err));
    }

  return (
    <div style={{display: "grid", margin: "10px", justifyContent: "center"}}>

        <h2 style={{color: "darkgray"}}>LOGIN</h2>
        <h4>Welcome to Tech Space</h4>
        <img src='https://procomp.ba/modules/jscomposer/uploads/laptopi-wide-banner.jpg'></img>
    <TextField style={{margin: "5px"}} id="outlined-basic" label="Email" variant="outlined" onChange={(event) => setEmail(event.target.value)} value={email}/>
    <TextField style={{margin: "5px"}} id="outlined-basic-2" label="Password" variant="outlined" onChange={(event) => setPassword(event.target.value)} value={password}/>
    <Button style={{margin: "5px", backgroundColor:"cadetblue"}} variant="contained" onClick={login}>LOGIN</Button>
    </div>
  );
}

export default Login;
