import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import axios from 'axios';
import Header from './Header';

export default function News() {

    const [inventory, setInventory] = React.useState([]);
    React.useEffect(() => {
        axios.defaults.headers.post['Content-Type'] ='application/x-www-form-urlencoded';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        axios.defaults.headers.post['Authorization'] = localStorage.getItem("techWebToken");
        axios.get(`http://localhost/news`)
      .then(res => {
        console.log(JSON.parse(res.data.replace("{}", "").replace('""', '"empty"')).empty.List.item);
        setInventory([JSON.parse(res.data.replace("{}", "").replace('""', '"empty"')).empty.List.item]);
      }).catch(err => console.log(err));

    }, [])
  return (
   <><Header></Header><List sx={{ width: '100%', maxWidth: 1000, bgcolor: 'background.paper' }}>
<div>
    <h2 style={{color: "chocolate"}}>News</h2>
    <h3 style={{color: "darksalmon"}}>Welcome to the latest news in tech industry - you can always stay up to date with us</h3>
    </div>
    <Divider/>
          {inventory.map(inventory => <> <ListItem alignItems="flex-start">
              <ListItemAvatar>
                  <Avatar alt="Remy Sharp" src={inventory.imageUrl} />
              </ListItemAvatar>
              <ListItemText
                  primary={inventory.headline}
                  secondary={<React.Fragment>
                      <Typography
                          sx={{ display: 'block' }}
                          component="span"
                          variant="body2"
                          color="text.primary"
                      >
                          {inventory.description}
                      </Typography>
                      

                  </React.Fragment>} />
          </ListItem>
              <Divider variant="inset" component="li" /></>)}
      </List></>
  );
}
