const Footer = () => {
    return (
      <div className='text-light' style={{ backgroundColor: 'rgba(0, 0, 0, 1)' }}>
        &copy; {new Date().getFullYear()} Copyright:{' '}
        <span className='text-light'>
          @Sagar Das
        </span>
      </div>
  );
}
export default Footer;