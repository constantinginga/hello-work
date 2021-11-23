using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Applications
{
    interface IApplicationData
    {
        Task<Application> AddApplication(Application application);

        Task<IList<Application>> GetApplications();
        public void UploadFile(int applicationId, string fileName, string file); 
        public Task<string> GetFile(int applicationId, string fileName); 

        public Task UpdateApplication(Application application);

    }
}
