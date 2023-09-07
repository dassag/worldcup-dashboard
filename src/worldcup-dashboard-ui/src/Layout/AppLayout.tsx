import { FunctionComponent } from 'react';
import './Style/AppLayout.scss';

interface AppLayoutProps {
    header: React.ReactElement,
    content: React.ReactElement,
    footer: React.ReactElement
}
 
const AppLayout: FunctionComponent<AppLayoutProps> = ({header, content, footer}) => {
    return ( 
        <div style={{width:'100%'}}>
            <div className='header'>{header}</div>
            <div className='app-content'>{content}</div>
            {footer}
        </div>
     );
}
 
export default AppLayout;