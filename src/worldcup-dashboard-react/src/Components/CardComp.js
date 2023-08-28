import React, { useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

export const CardComp = ({winner}) =>{
  return (
    <Card style={{ width: '18rem', height:'20rem', backgroundColor:'gray'}}>
      
      <Card.Body>
        <Card.Title style={{ marginTop: '1rem' }}><h2>{winner.name} - {winner.id}</h2></Card.Title>
        <Card.Img variant="top" src="holder.js/100px180" />
        <Card.Text style={{marginTop:'10rem'}}>
          Won By - { winner.winner}
        </Card.Text>
        <Button className="primary">Get All Match Details </Button>
      </Card.Body>
    </Card>
  );
}