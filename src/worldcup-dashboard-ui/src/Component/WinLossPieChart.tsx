import { PieChart } from 'react-minimal-pie-chart';
interface WinLossPieChartProps{
    totalWins: number,
    totalLoss: number
}
const WinLossPieChart = (props:WinLossPieChartProps) => {
    return (<PieChart
  data={[
        { title: 'Win', value: props.totalWins, color: '#4da375' },
        { title: 'Loss', value: props.totalLoss, color: '#a34d5d' }
        ]}
/>)
}
export default WinLossPieChart;