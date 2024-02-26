import './Card.css'

export const Card = () => {
  return (
    <>
        <img className="dogImg" src="/public/luque.jpg" alt="nombre perro" />
        <h2 className='dogName'>Nombre de perro</h2>
        <p className='dogAge'>3 años</p>
        <p className='dogCity'>Ciudad</p>
        <p className='dogDescription'>Descripción</p>
    </>
  )
}
