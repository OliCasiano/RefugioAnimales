
import { Header } from '../components/header/Header'
// import { useEffect, useState } from 'react';
import { Card } from '../components/Card/Card';

export const HomePage = () => {
  // const [cards, setCards] = useState("")
  
  // const URL = "http://localhost:8080/announcement";

  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await fetch(URL);
  //       if (!response.ok) {
  //         throw new Error("Network response was not ok");
  //       }
  //       const data = await response.json();
  //       setCards(data);
  //     } catch (error) {
  //       console.error("Error fetching data:", error);
  //     }
  //   };
  // })()
    

  return (
    <div>
      <Header />
      <Card />
      </div>
    
  )
}
