import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { useState } from 'react';

export default function BasicDatePicker() {
  const [currentDate, setCurrentDate] = useState<string>('');

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DemoContainer components={['DatePicker']}>
        <div style={{ width: '100px' }}>
          <DatePicker
            label="start date"
            value={currentDate}
            onChange={(newValue) => {
              setCurrentDate(newValue);
              console.log(newValue);
            }}
          />
        </div>
      </DemoContainer>
    </LocalizationProvider>
  );
}
