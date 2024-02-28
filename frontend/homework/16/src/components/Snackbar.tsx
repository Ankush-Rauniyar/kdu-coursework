import * as React from 'react';
import Snackbar from '@mui/material/Snackbar';
import Alert from '@mui/material/Alert';
import { Box } from '@mui/material';
import { RootState } from '../redux/Store';
import { useSelector } from 'react-redux';

export default function CustomizedSnackbars() {
  const [open, setOpen] = React.useState(true);
  const severityStatus = useSelector((state:RootState)=> state.snackbar.status);
  const content = useSelector((state:RootState)=>state.snackbar.message);
  console.log(severityStatus);

  const handleClose = (reason: string) => {
    if (reason === 'clickaway') {
      return;
    }

    setOpen(false);
  };

  return (
    <Box
      display="flex"
      justifyContent="center"
      alignItems="flex-end"
      height="100vh"
      padding={2}
    >
      <Snackbar
        open={open}
        autoHideDuration={6000}
        onClose={(event, reason) => handleClose(reason)}
        anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
      >
        <Alert
          onClose={() => handleClose('')}
          severity={severityStatus === "error"?"error" : "success"}
          variant="filled"
          sx={{ width: '100%' }}
        >
            {content}
        </Alert>
      </Snackbar>
    </Box>
  );
}
