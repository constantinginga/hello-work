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
        public Task UpdateApplication(Application application);

    }
}
