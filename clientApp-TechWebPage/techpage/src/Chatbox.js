import React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import axios from 'axios';
import { withRouter } from "react-router";
import { useHistory } from "react-router-dom";
import Header from './Header';
import Chip from '@mui/material/Chip';

function Chatbox(props) {
    const history = useHistory();
    const [text, setText] = React.useState("");
    const [chatH, setChatH] = React.useState([{position: 2, label: "Hello"}]);
    const [errorP, setErrorP] = React.useState(false);
    
    const chat =  () => {
        setErrorP(false);
        /*axios.interceptors.response.use((response) => {
            return response
          }, (error) => {
            console.log(error)
            if (error.response && error.response.data && error.response.data.location) {
              window.location = error.response.data.location
            } else {
              return Promise.reject(error)
            }
          })*/
        let newC = [...chatH, {position:1, label: text}];
        
        console.log(text)
        axios.defaults.headers.post['Content-Type'] ='application/x-www-form-urlencoded';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        axios.defaults.headers.post['Accept'] = '*';
        axios.defaults.headers.post['Authorization'] = localStorage.getItem("techWebToken");
        
        axios.get(`http://localhost/chat?msg=` + text, {
            redirect: "manual"
        })
      .then(res => {
        console.log(res);
        setChatH([...newC, {position:2, label: res.data}])
      }).catch(err => setErrorP("It's not allowed to ask that."));
        setText("");
    }

  return ( <><Header></Header>

   <div style={{ marginLeft: "20%", marginRight:"20%", marginTop: "5%" }}>
    <div style={{ margin: "10px", display: "grid"}}>
         {chatH.map(
        c => {
            if (c.position == 1) 
            return <div><Chip style={{width: "fit-content", float: "right", backgroundColor: "antiquewhite", color: "chocolate"}} label={c.label}/></div>
            else
            return <div><Chip style={{width: "fit-content", float: "left",backgroundColor: "chocolate", color: "antiquewhite"}} label={c.label}/></div>
        }
    )}
 </div>
 <div style={{ margin: "10px", marginTop: "60px", display: "block"}}>
 <TextField 
 style ={{width: "92%",  backgroundColor: "whitesmoke", float: "left"}} 
 onChange={(event) => setText(event.target.value)}
 value={text}
 size="small" 
 id="outlined-basic" 
 label="Your question?" 
 error={errorP}
 helperText={errorP}
 variant="outlined" />
 <Button style={{ width: "6%", float: "right"}} onClick = {chat}>Ask</Button>
 </div>
 
 </div>
 </>
 
  );
}

export default Chatbox;
