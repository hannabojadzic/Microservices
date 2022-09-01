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
import Paper from '@mui/material/Paper';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';

export default function TechList() {

    const [inventory, setInventory] = React.useState([]);
    const [openDetails, setOpenDetails] = React.useState(false);
    React.useEffect(() => {
        axios.defaults.headers.post['Content-Type'] ='application/x-www-form-urlencoded';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        axios.defaults.headers.post['Authorization'] = localStorage.getItem("techWebToken");
        axios.post(`http://localhost/inventory`)
      .then(res => {
        console.log(res);
        setInventory(res.data);
      }).catch(err => console.log(err));

    }, [])

    const [selectedInventory, setSelectedInventory] = React.useState(null);
    const [selectedPaymentOptions, setSelectedPaymentOptions] = React.useState(null);

    const click = (inventory) => {
        console.log(inventory);
        axios.defaults.headers.post['Content-Type'] ='application/x-www-form-urlencoded';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        axios.defaults.headers.post['Authorization'] = localStorage.getItem("techWebToken");
        axios.post(`http://localhost/inventory_billing?id=` + inventory.id)
      .then(res => {
        console.log(res);
        setSelectedInventory(res.data.results[1].body);
        console.log(res.data.results[1].body)
        setSelectedPaymentOptions(res.data.results[0].body.payments);
        console.log(res.data.results[0].body)
      }).catch(err => console.log(err));
        
        setOpenDetails(true);
    }
  return (
   <> <Header></Header>
   {
    !openDetails && <><List sx={{ width: '100%', maxWidth: 1000, bgcolor: 'background.paper' }}>
    {inventory.map(inventory => <> <ListItem alignItems="flex-start" onClick={(event) => click(inventory)}>
        <ListItemAvatar>
            <Avatar alt="Remy Sharp" src={inventory.imageUrl} />
        </ListItemAvatar>
        <ListItemText
            primary={inventory.name}
            secondary={<React.Fragment>
                <Typography
                    sx={{ display: 'block' }}
                    component="span"
                    variant="body2"
                    color="text.primary"
                >
                    {inventory.shortDesc}
                </Typography>
                <Typography

                    component="span"
                    variant="body2"
                    color="text.primary"
                >
                    {inventory.price}
                </Typography>

            </React.Fragment>} />
    </ListItem>
        <Divider variant="inset" component="li" /></>)}
</List></>
   }
   {
    openDetails && selectedInventory && selectedPaymentOptions && <>
   
    <Card sx={{ width: "100%" }}>
      <CardMedia
      sx={{width: "auto", margin: "auto"}}
        component="img"
        alt="green iguana"
        height="400"
        image={selectedInventory.imageUrl}
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
        {selectedInventory.name}
        </Typography>
        <Typography style={{fontWeight: "700"}} gutterBottom variant="h5" component="div">
        {selectedInventory.price}
        </Typography>
        <Typography variant="body2" color="text.secondary">
        {selectedInventory.description}
        </Typography>
        <div style={{padding: "10px"}}>
            RAM: {selectedInventory.ram}
        </div>
        <div style={{padding: "10px"}}>
            CPU: {selectedInventory.cpu}
        </div>
        <div style={{padding: "10px"}}>
            Graphics: {selectedInventory.graphics}
        </div>
        <div style={{padding: "10px"}}>
            Disk : {selectedInventory.hdd}
        </div>
        <div style={{padding: "10px"}}>
            Ports: {selectedInventory.ports}
        </div>
        <div style={{padding: "10px"}}>
            Display: {selectedInventory.display}
        </div>
        <div style={{padding: "10px"}}>
        PAYMENT OPTIONS
        </div>
        <div style={{display: "flex", justifyContent: "center"}}>
            
            {
                selectedPaymentOptions.map(
                    pO => <div style={{padding: "10px"}}>
                   <img style={{width: "80px", height: "70px"}} src={pO.logo}></img>
                </div>
                )
            }
        </div>
      </CardContent>
      <CardActions>
        <Button style={{backgroundColor: "cadetblue"}} variant="contained" size="big" onClick={(event) => setOpenDetails(false)}>BACK</Button>
        <Button style={{backgroundColor: "cornflowerblue"}} variant="contained" size="big">BUY</Button>
      </CardActions>
    </Card>

    </>
   }
</>
  );
}
